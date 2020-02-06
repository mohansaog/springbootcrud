package com.example.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
/*
 * @EnableAutoConfiguration
 * 
 * @ComponentScan(basePackages = "com.example.mysql")
 * 
 * @EnableJpaRepositories("com.example.mysql.dao")
 */
public class SpringMysqlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

}
