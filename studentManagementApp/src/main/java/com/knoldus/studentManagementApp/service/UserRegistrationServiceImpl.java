package com.knoldus.studentManagementApp.service;

import com.knoldus.studentManagementApp.dto.SellerDto;
import com.knoldus.studentManagementApp.service.resilience4j.UserRegistrationResilience4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationResilience4j userRegistrationResilience4j;


    public UserRegistrationServiceImpl(UserRegistrationResilience4j userRegistrationResilience4j) {
        this.userRegistrationResilience4j = userRegistrationResilience4j;
    }

    @Override
    public String registerSeller(SellerDto sellerDto) throws InterruptedException {

        String registerSeller = null;

        for (int i = 0; i < 100; i++) {

            long start = System.currentTimeMillis();

            new Thread(() -> {
                try {
                    userRegistrationResilience4j.registerSeller(sellerDto);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "service-call").start();
            logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
            Thread.sleep(50);
        }

        return registerSeller;

    }

    @Override
    public List<SellerDto> getSellersList() {
        return List.of(new SellerDto());
    }
}
