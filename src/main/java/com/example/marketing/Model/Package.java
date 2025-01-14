package com.example.marketing.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int package_id;

    @Min(value = 1, message = "Package times must be at least 1")
    @Column(nullable = false)
    private int package_times;

    @Min(value = 0, message = "Package price must be greater than or equal to 0")
    @Column(nullable = false)
    private int package_price;

    @NotBlank(message = "Platform name cannot be blank")
    @Size(min = 3, max = 50, message = "Platform name must be between 3 and 50 characters")
    @Column(nullable = false)
    private String platform_name;

    @Column(nullable = false)
    private boolean isAvailable;

    @ManyToOne
    @JsonIgnore
    private Influencer influencer;
}