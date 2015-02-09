package gdes.amisdufoot;

import gdes.amisdufoot.converter.AdfSaisonToSaisonConverter;
import gdes.amisdufoot.converter.SaisonToAdfSaisonConverter;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class ApplicationConfig {

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

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(
				ApplicationConfig.class, args);

		// init de la base (à supprimer ensuite)
		/*
		SaisonRepository saisonRepository = context
				.getBean(SaisonRepository.class);
		saisonRepository.save(new Saison("2011-2012"));
		saisonRepository.save(new Saison("2010-2011"));
		*/
	}

}
