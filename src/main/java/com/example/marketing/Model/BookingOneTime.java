package com.example.marketing.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class BookingOneTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booking_id;

    @NotNull(message = "Booking date cannot be null")
    @FutureOrPresent(message = "Booking date must be today or in the future")
    @Column(nullable = false)
    private LocalDate booking_date;

    @NotBlank(message = "Booking status cannot be blank")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$", message = "Booking status must be PENDING, CONFIRMED, or CANCELLED")
    @Column(nullable = false)
    private String booking_status;

    @NotBlank(message = "Total price cannot be blank")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Total price must be a valid number with up to two decimal places")
    @Column(nullable = false)
    private String booking_totalPrice;

    @ManyToOne
    @JsonIgnore
    private Company company;

    @ManyToOne
    @JsonIgnore
    private Influencer influencer;

    @ManyToOne
    @JsonIgnore
    private Platform platform;

    @ManyToOne
    @JsonIgnore
    private Type type;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Review> reviews;


}
