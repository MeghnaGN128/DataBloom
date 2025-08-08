package com.xworkz.earbuds.controller;

import com.xworkz.earbuds.dto.EarbudsDTO;
import com.xworkz.earbuds.service.EarbudsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EarbudsController {

    @Autowired
    private EarbudsService earbudsService;

    public EarbudsController(){
        System.out.println("Running in EarbudsController");
    }
  @GetMapping("redirect")
    public String onRedirect(){
      System.out.println("onRedirect running in EarbudsController");
      return "Earbuds";
  }

  @PostMapping("save")
    public  String onSave(EarbudsDTO earbudsDTO, Model model){
      System.out.println("onSave running in EarbudsController");

      if (earbudsService.validate(earbudsDTO)) {
          model.addAttribute("data","saved");
          model.addAttribute("earbudsDTO", earbudsDTO);
      }else {
          model.addAttribute("data", "notsaves");
          model.addAttribute("earbudsDTO",earbudsDTO);
          model.addAttribute("brand", earbudsDTO.getBrand());
          model.addAttribute("price", earbudsDTO.getPrice());
      }
      return "EarbudsSuccess";
  }


}
