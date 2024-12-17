package com.example.marketing.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingPackageDTO {

    private Integer bookingPackageId;
    private Long total;
    private LocalDate bookingDate;
    private Long bookingTotalPrice;
    private String bookingStatus;
    private Integer companyId;
    private Integer influencerId;
    private Integer packageId;
}
