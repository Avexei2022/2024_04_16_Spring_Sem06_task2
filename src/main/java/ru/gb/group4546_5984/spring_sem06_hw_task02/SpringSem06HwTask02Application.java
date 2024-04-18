package ru.gb.group4546_5984.spring_sem06_hw_task02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringSem06HwTask02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSem06HwTask02Application.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}
}
