package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class CouponAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponAssignmentApplication.class, args);
		System.out.println("Done..!!");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
