package com.xworkz.supermarket.controller;

import com.xworkz.supermarket.dto.ProductDTO;
//import com.xworkz.supermarket.service.EmailSender;
import com.xworkz.supermarket.service.EmailSender;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class ProductController {

    @PostMapping("/")
    public String getProduct(ProductDTO productDTO, Model model) throws  IOException{
        System.out.println("getProduct method in controller");

        MultipartFile multipartfile=productDTO.getProductImage();
        System.out.println(multipartfile);

        byte[] bytes = multipartfile.getBytes();
        System.out.println(bytes);

        Path path = Paths.get("C:\\file upload\\"+productDTO.getProductName()+"_"+System.currentTimeMillis());
        Files.write(path,bytes);

        String fileName = path.getFileName().toString();
        productDTO.setProductName(fileName);

        model.addAttribute("file",fileName);
        model.addAttribute("dto",productDTO);
//        getOtp(productDTO);
        return "ProductSuccess";

    }

    @GetMapping("download")
    public void download(HttpServletResponse response, @RequestParam("profile") String profile) throws IOException {
        response.setContentType("img/jpg");
        File file=new File("C:\\file upload\\"+profile);
        InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream= response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
        response.flushBuffer();
    }

    @Autowired
    EmailSender emailSender;

@PostMapping("/product")
   public  String getOtp(ProductDTO productDTO){
        System.out.println("sendEmail :"+productDTO);
       emailSender.mailSender(productDTO.getEmail(),"9874");
        System.out.println("End ");
       return "sendEmail";
   }

}
