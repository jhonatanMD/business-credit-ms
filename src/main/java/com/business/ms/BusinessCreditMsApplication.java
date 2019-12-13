package com.business.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class BusinessCreditMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessCreditMsApplication.class, args);
	}

}
