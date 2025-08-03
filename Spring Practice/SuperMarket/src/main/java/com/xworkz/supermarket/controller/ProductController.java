package com.xworkz.supermarket.controller;

import com.xworkz.supermarket.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductController {

    @RequestMapping("/product")
    public String getProduct(@Valid ProductDTO productDTO, BindingResult bindingResult, Model model) {
        System.out.println("getProduct method in controller");

        if (bindingResult.hasErrors()) {
            System.out.println("Error occurred");
            bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + "- " + fieldError.getDefaultMessage())
                    .forEach(System.out::println);

            model.addAttribute("message", "Details not valid");
            model.addAttribute("dto", productDTO);
            return "Product";
        }

        System.out.println("Product Submitted");
        model.addAttribute("message", productDTO.getProductName());
        model.addAttribute("productDTO", productDTO);

        return "ProductSuccess";
    }
}
