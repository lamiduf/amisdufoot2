package com.gdes.amiduf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.gdes.amiduf.converter.AdfSaisonToSaisonConverter;
import com.gdes.amiduf.converter.SaisonToAdfSaisonConverter;

@SpringBootApplication
public class AmidufWebApplication {

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

	
	public static void main(String[] args) {
        SpringApplication.run(AmidufWebApplication.class, args);
    }
    
    
    
}
