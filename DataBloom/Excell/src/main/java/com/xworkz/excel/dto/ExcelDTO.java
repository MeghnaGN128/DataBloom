package com.xworkz.excel.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
@Data
public class ExcelDTO {

    @NotNull(message = "Excel file")
    private MultipartFile excelFile;
}
