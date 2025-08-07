package com.xworkz.excel.controller;

import com.xworkz.excel.dto.ExcelDTO;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ExcelController {

    private static final String UPLOAD_DIR = "C:\\file upload\\";

    private List<List<String>> readExcelSheet(MultipartFile file) {
        List<List<String>> excelData = new ArrayList<>();
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    CellType cellType = cell.getCellType();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData.add(cell.getDateCellValue().toString());
                            } else {
                                rowData.add(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case FORMULA:
                            rowData.add(cell.getCellFormula());
                            break;
                        case BLANK:
                            rowData.add("");
                            break;
                        default:
                            rowData.add("");
                    }
                }
                excelData.add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelData;
    }

    @RequestMapping("/send")
    public String getExcel(ExcelDTO excelDTO, Model model) throws IOException {
        MultipartFile multipartfile = excelDTO.getExcelFile();

        byte[] bytes = multipartfile.getBytes();
        String originalFileName = multipartfile.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + originalFileName + "_" + System.currentTimeMillis());
        Files.write(path, bytes);

        List<List<String>> excelData = readExcelSheet(multipartfile);

        String fileName = path.getFileName().toString();

        model.addAttribute("file", fileName);
        model.addAttribute("excelData", excelData);
        model.addAttribute("dto", excelDTO);

        return "ExcelSuccess";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, @RequestParam("profile") String profile) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        File file = new File(UPLOAD_DIR + profile);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
             ServletOutputStream outputStream = response.getOutputStream()) {
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        }
    }
}
