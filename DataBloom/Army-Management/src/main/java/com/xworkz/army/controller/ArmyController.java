package com.xworkz.army.controller;

import com.xworkz.army.dto.ArmyDTO;
import com.xworkz.army.service.ArmyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ArmyController {

    @Autowired
    private ArmyService armyService;
    public ArmyController() {
        System.out.println("Running in ArmyController");
    }

    @GetMapping("enter")
    public String onArmy() {
        System.out.println("onArmy running in ArmyController");
        return "Army";
    }


    @GetMapping("give")
    public String giveArmy() {
        System.out.println("giveArmy running in ArmyController");
        return "index";
    }

    @PostMapping("save")
    public String saveArmy(ArmyDTO armyDTO, Model model) {
        System.out.println("saveArmy running in ArmyController"+armyDTO);
        if(armyService.validate(armyDTO)){
            model.addAttribute("message","saved");
            return featchAll(model);
        }else {
            model.addAttribute("message","notsaved");
            model.addAttribute("armyDTO",armyDTO);


        }
        return "Army";
    }

    @GetMapping("featchAll")
    public  String featchAll(Model model){
        System.out.println("featchall in controller");
        List<ArmyDTO> l=armyService.fetchAll();
        model.addAttribute("armies",l);
        l.forEach(System.out::println);
        return "Alldata";
    }
@GetMapping("show")
    public String onShow(@RequestParam("id") String id,Model model){
    System.out.println("featch id in controller"+id);
    ArmyDTO armyDTO=armyService.featchById(Integer.valueOf(id));
    model.addAttribute("army",armyDTO);
    System.out.println("onshow"+armyDTO);
    return "show";
}


@GetMapping("edit")
    public  String updatedById(@RequestParam("id")String id,Model model){
    System.out.println("id : "+id);
    ArmyDTO armyDTO=armyService.featchById(Integer.valueOf(id));
    System.out.println("controller: "+armyDTO);
    model.addAttribute("ref",armyDTO);
    return "update";
}
 @PostMapping("update")
    public String onUpdate(ArmyDTO armyDTO,Model model){
     System.out.println("onUpdate in ArmyController");
     System.out.println(armyDTO);
     String update=armyService.updateArmyEntityById(armyDTO);
     System.out.println("update"+update);
     List<ArmyDTO> list=armyService.fetchAll();
     list.forEach(System.out::println);
     model.addAttribute("armies",list);
     return "Alldata";
    }

    @GetMapping("delete")
    public String onDelete(@RequestParam("id")String id,Model model){
        System.out.println("id"+id);
        String delete=armyService.deleteById(Integer.valueOf(id));
        System.out.println(delete);
        List<ArmyDTO> l=armyService.fetchAll();
        model.addAttribute("armies",l);
        l.forEach(System.out::println);
        return "Alldata";
    }

}
