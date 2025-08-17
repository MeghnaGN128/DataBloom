package com.xworkz.tourism.dto;

import javax.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString
public class TourismDTO {

    @NotNull(message = "Tour ID cannot be null")
    private Integer tourID;

    @NotBlank(message = "Destination is required")
    @Size(min = 3, max = 50, message = "Destination must be between 3 and 50 characters")
    private String destination;

    @NotBlank(message = "Start point is required")
    @Size(min = 3, max = 50, message = "Start point must be between 3 and 50 characters")
    private String startPoint;

    @NotNull(message = "Package price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Package price must be greater than 0")
    private Double packagePrice;

    @NotBlank(message = "Vehicle is required")
    private String vehicle;

    @NotBlank(message = "Vehicle number is required")
    @Pattern(regexp = "^[A-Z0-9-]{5,15}$", message = "Invalid vehicle number format")
    private String vehicleNumber;

    @NotNull(message = "Number of people cannot be null")
    @Min(value = 1, message = "At least 1 person is required")
    @Max(value = 100, message = "Number of people cannot exceed 100")
    private Integer noOfPeople;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;
}
