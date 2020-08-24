package com.knoldus.studentManagementApp.service;

import com.knoldus.studentManagementApp.dto.SellerDto;

import java.util.List;


public interface UserRegistrationService {
    String registerSeller(SellerDto sellerDto) throws InterruptedException;

    List<SellerDto> getSellersList();
}
