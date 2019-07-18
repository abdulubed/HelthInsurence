package com.usa.fedaral.gov.ssa.util;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ssa")
@Data
public class AppProperties {
	
	private String enrollSuccess;
	private String enrollFailure;
	private String message;
	private String userRegistration;

}
