package com.example.marketing.Controller;

import com.example.marketing.Service.BookingPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookingPackage")
@RequiredArgsConstructor
public class BookingPackageController {

    private final BookingPackageService bookingPackageService;



}
