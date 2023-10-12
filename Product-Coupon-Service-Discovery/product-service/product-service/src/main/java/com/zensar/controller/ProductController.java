package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Product;
import com.zensar.rest.client.RestClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	private ProductService productService;

	 @Autowired
	 private RestClient restClient;

//	@Autowired
//	private RestTemplate restTemplate;

	// http://localhost:8082/product-api/product -> POST
	@PostMapping("/product")
	@CircuitBreaker(name = "serviceA", fallbackMethod = "fallbackMethod")
	public Product insertProduct(@RequestBody Product product) {

//		CouponDto couponDto = restTemplate
//				.getForObject("http://localhost:8083/coupon-api/coupons/" + product.getCouponCode(), CouponDto.class);

		// CouponDto couponDto =
		// restTemplate.getForObject("http://COUPON-SERVICE/coupon-api/coupons/"+product.getCouponCode(),CouponDto.class);

		try {
			CouponDto couponDto = restClient.getCoupon(product.getCouponCode());
			String couponCode = couponDto.getCouponCode();

			String numberOnly = couponCode.replaceAll("[^0-9]", "");
			Double doubleCoversionofCouponCode = Double.valueOf(numberOnly);
			System.out.println(" doubleCoversionofCouponCode "+doubleCoversionofCouponCode);
			product.setPrice(product.getPrice() - doubleCoversionofCouponCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		return productService.insertProduct(product);

	}

	public Product fallbackMethod(Exception e) {
		return new Product();
	}

}
