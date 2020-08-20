package com.knoldus.studentManagementApp.service.resilience4j;

import com.knoldus.studentManagementApp.dto.SellerDto;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserRegistrationResilience4j {
    Logger logger = LoggerFactory.getLogger(UserRegistrationResilience4j.class);
    private RestTemplate restTemplate;

    public UserRegistrationResilience4j(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


 @Bulkhead(name = "bulkheadService1", fallbackMethod = "bulkHeadFallback")
    public String registerSeller(SellerDto sellerDto) throws InterruptedException {
        String response = restTemplate.postForObject("/addSeller", sellerDto, String.class);
        return response;
    }

    public String bulkHeadFallback(SellerDto sellerDto, Throwable t) {
        logger.error("Inside bulkHeadFallback, cause - {}", t.toString());
        return "Inside bulkHeadFallback method. Some error occurred while calling service for seller registration";
    }
}
