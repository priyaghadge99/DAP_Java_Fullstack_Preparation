package com.gateway.apigateway;

import org.apache.hc.core5.http.impl.DefaultAddressResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public HttpClient httpClient() {
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}

}
