package com.xworkz.user.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterDTO {

    private Integer id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    private String email;

    @NotNull
    @Min(1000000000L)
    private Long mobile;

    @NotBlank
    private String dob;

    @NotBlank
    private String gender;

    @NotBlank
    private String state;

    @NotBlank
    private String address;

    private Integer loginCount;
}
