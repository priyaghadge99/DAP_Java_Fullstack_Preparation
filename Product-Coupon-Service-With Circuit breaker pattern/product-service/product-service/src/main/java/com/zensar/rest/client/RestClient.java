package com.zensar.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.dto.CouponDto;



//@FeignClient("COUPON-SERVICE")
//@FeignClient(name ="COUPON-SERVICE" ,url = "http://localhost:8083/")
@FeignClient(name="API-GATEWAY",url = "http://localhost:8080/")
public interface RestClient {

	@GetMapping("/coupon-api/coupons/{couponCode}")
	CouponDto getCoupon(@PathVariable("couponCode") String couponCode);
	
	
	

}
