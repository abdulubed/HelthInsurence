package com.abdul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.abdul.sample.method.SampleMethod;

@SpringBootApplication
public class WorkWithFormsApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context =SpringApplication.run(WorkWithFormsApplication.class, args);
	 context.getBean(SampleMethod.class);
		
	}
	
	

}
