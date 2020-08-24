package com.knoldus.registrationService.service;

import com.knoldus.registrationService.dto.SellerDto;

import java.util.List;


public interface RegistrationService {


    String addSeller(SellerDto sellerDto) throws InterruptedException;

    List<SellerDto> getSellersList();
}
