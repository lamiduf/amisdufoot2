package gdes.amisdufoot;

import gdes.amisdufoot.converter.AdfSaisonToSaisonConverter;
import gdes.amisdufoot.converter.SaisonToAdfSaisonConverter;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ApplicationConfig extends WebMvcConfigurerAdapter {

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
	
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHttpRequestInterceptor());
    }

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean(); 
	}

	public static void main(String[] args) {

		SpringApplication.run(
				ApplicationConfig.class, args);

	}


}
