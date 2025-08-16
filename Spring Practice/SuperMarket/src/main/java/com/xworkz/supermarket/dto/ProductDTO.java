package com.xworkz.supermarket.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
@ToString
public class ProductDTO {
    @NotBlank
    private String productName;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double price;

    @Size(max = 200)
    private String description;

    @NotNull
    private String Email;

    @NotNull
    private MultipartFile productImage;
}
