package com.snspj.configuration;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:properties/kakao.properties")
public class PropertiesConfiguration {
	
	@Bean(name = "kakaoApi")
	public PropertiesFactoryBean propertiesFactoryBean() throws Exception{
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setFileEncoding("UTF-8");
		ClassPathResource classPathResource = new ClassPathResource("properties/kakao.properties");
		bean.setLocation(classPathResource);
		return bean;
	}

}
