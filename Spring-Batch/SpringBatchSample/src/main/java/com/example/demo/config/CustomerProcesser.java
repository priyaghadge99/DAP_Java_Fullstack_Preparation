package com.example.demo.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.entity.CustomerEntity;

public class CustomerProcesser implements ItemProcessor<CustomerEntity, CustomerEntity>{

	@Override
	public CustomerEntity process(CustomerEntity item) throws Exception {
		return item;
	}

}
