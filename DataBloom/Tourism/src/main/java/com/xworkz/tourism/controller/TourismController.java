package com.xworkz.tourism.controller;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TourismController {

    @Autowired
    @Value("${custom.message:Default message if not found}")
    private String message=" ";


    @Autowired
    TourismService service;

    public TourismController(){
        System.out.println("created TourismController");
    }

    @GetMapping("redirectToTourism")
    public String redirectToTourism(){
        System.out.println("redirecting to tourism.jsp");
        return "tourism";
    }

    @PostMapping("saveData")
    public String saveData(TourismDTO dto, Model model){

        System.out.println(dto);
        boolean valid= service.saveTourism(dto);
        if(valid){
            System.out.println("data is valid");
            System.out.println("Controller: "+dto);
            model.addAttribute("success","success");
            System.out.println("data saved into database");
        }
        else{
            System.out.println("validation gone wrong");
            model.addAttribute("error","data invalid...check console");
        }

        model.addAttribute("dto",dto);
        List<TourismDTO> tourismDTOList=service.fetchAll();
        System.out.println("Controller: "+tourismDTOList);
        model.addAttribute("tourismDTOList",tourismDTOList);
        return "AllEntity";

    }

    @GetMapping("fetchAll")
    public String fetchAll(Model model){
        List<TourismDTO> tourismDTOList=service.fetchAll();
        System.out.println("Controller: "+tourismDTOList);
        model.addAttribute("tourismDTOList",tourismDTOList);
        return "AllEntity";
    }

    @GetMapping("backToIndex")
    public String backToIndex(){
        return "index";
    }

    @PostMapping("findByID")
    public String findByID(Integer id,Model model){
        System.out.println("running findByID in Controller");
        TourismDTO dto=service.findByID(id);
        model.addAttribute("dto",dto);

        return "AllEntity";
    }

    @GetMapping("redirectToFind")
    public String redirectToFind(){
        System.out.println("running redirectToFind in Controller");
        return "FindById";
    }

    @GetMapping("getByID")
    public String getByID(@RequestParam("id") Integer id,Model model){
        System.out.println("id to find"+id);

        TourismDTO dto=service.findByID(id);
        System.out.println("data found at "+id+" = "+dto);
        model.addAttribute("dto",dto);

        return "TourismData";
    }

    @GetMapping("edit")
    public String redirectToEdit(@RequestParam("id") String id, Model model){
        System.out.println("running redirectToEdit, id= "+id);
        TourismDTO dto=service.findByID(Integer.valueOf(id));
        System.out.println("dto in redirect to edit: "+dto);
        model.addAttribute("dto",dto);
        return "EditTourismForm";
    }

    @PostMapping("update")
    public String updateTourism(TourismDTO dto,Model model){
        System.out.println("running updateTourism in Controller");
        System.out.println("dto: "+dto);
        String message=service.updateTourism(dto);
        System.out.println("message: "+message);
        model.addAttribute("message",message);
        List<TourismDTO> tourismDTOList=service.fetchAll();
        System.out.println("Controller: "+tourismDTOList);
        model.addAttribute("tourismDTOList",tourismDTOList);
        return "AllEntity";
    }

    @GetMapping("fetcAll")
    public String fetcAll(Integer id, Model model){
        List<TourismDTO> tourismDTOList=service.fetchAll();
        System.out.println("Controller: "+tourismDTOList);
        model.addAttribute("tourismDTOList",tourismDTOList);
        String message=service.deleteById(id);
        model.addAttribute("message", message);
        return "AllEntity";
    }


    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Integer id,Model model){
        System.out.println("running deleteById in Controller..., id: "+id);
        return "redirect:/fetcAll";
    }
}