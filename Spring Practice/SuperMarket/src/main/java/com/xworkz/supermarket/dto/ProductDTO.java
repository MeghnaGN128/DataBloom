package com.xworkz.supermarket.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductDTO {
    @NotBlank
    private String productName;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double price;

    @Size(max = 200)
    private String description;

}
