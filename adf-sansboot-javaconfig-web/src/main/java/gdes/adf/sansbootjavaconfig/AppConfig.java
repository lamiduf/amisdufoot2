package gdes.adf.sansbootjavaconfig;

import gdes.adf.sansbootjavaconfig.converter.AdfSaisonToSaisonConverter;
import gdes.adf.sansbootjavaconfig.converter.SaisonToAdfSaisonConverter;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan({ "gdes.adf.sansbootjavaconfig.converter",
		"gdes.adf.sansbootjavaconfig.domain" })
@EnableJpaRepositories("gdes.adf.sansbootjavaconfig.domain")
@PropertySource("classpath:adf.properties")
public class AppConfig {
	
	@Autowired
	Environment env;

	@Bean  
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasename("messages");  
        source.setUseCodeAsDefaultMessage(true);  
        return source;  
    }  
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	
	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new AdfSaisonToSaisonConverter());
		converters.add(new SaisonToAdfSaisonConverter());
		return converters;
	}
	
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("datasource.driver"));
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUsername(env.getProperty("datasource.username"));
		dataSource.setPassword(env.getProperty("datasource.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.valueOf(env.getProperty("datasource.type")));
		jpaVendorAdapter.setGenerateDdl(true);
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean
				.setPackagesToScan("gdes.adf.sansbootjavaconfig.domain");

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.format_sql", "false");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.default_batch_fetch_size", "8");
		properties.put("hibernate.archive.autodetection", "class");
		properties.put("hibernate.cache.use_second_level_cache", "true");
		properties.put("hibernate.cache.region.factory_class",
				"org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		properties.put("hibernate.cache.use_query_cache", "true");
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return transactionManager;
	}

}
