package com.example.marketing.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookingPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingPackageId;

    private Long total;

    private LocalDate bookingDate;

    private Long bookingTotalPrice;

    private String bookingStatus;

    @ManyToOne
    @JsonIgnore
    private Company company;

    @ManyToOne
    @JsonIgnore
    private Influencer influencer;

    @ManyToOne
    @JsonIgnore
    private Package packageEntity;
}
