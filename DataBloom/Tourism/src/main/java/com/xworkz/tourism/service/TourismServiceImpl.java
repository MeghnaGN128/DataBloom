package com.xworkz.tourism.service;
import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourismServiceImpl implements TourismService{
    @Autowired
    TourismRepository repo;
    @Override
    public boolean saveTourism(TourismDTO dto) {
        if(dto!=null){
            System.out.println("dto is not null in service");
            System.out.println("Service: "+dto);

            TourismEntity entity=new TourismEntity();
            entity.setDestination(dto.getDestination());
            entity.setStartPoint(dto.getStartPoint());
            entity.setPackagePrice(dto.getPackagePrice());
            entity.setVehicle(dto.getVehicle());
            entity.setVehicleNumber(dto.getVehicleNumber());
            entity.setNoOfPeople(dto.getNoOfPeople());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());

            repo.saveTourism(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<TourismDTO> fetchAll() {

        List<TourismDTO> listOfDTOs = null;

        List<TourismEntity> listOfEntities = repo.fetchAll();
        System.out.println(listOfEntities);

        listOfEntities.stream().forEach(System.out::println);

        listOfDTOs = listOfEntities.stream().map(entity -> {
            TourismDTO dto = new TourismDTO();
            dto.setTourID(entity.getTourID());
            dto.setDestination(entity.getDestination());
            dto.setVehicle(entity.getVehicle());
            dto.setStartDate(entity.getStartDate());
            dto.setPackagePrice(entity.getPackagePrice());
            dto.setEndDate(entity.getEndDate());
            dto.setStartPoint(entity.getStartPoint());
            dto.setVehicleNumber(entity.getVehicleNumber());
            dto.setNoOfPeople(entity.getNoOfPeople());
            return dto;
        }).collect(Collectors.toList());

        System.out.println("Service: ");

        listOfDTOs.forEach(System.out::println);
        return listOfDTOs;
    }

    @Override
    public TourismDTO findByID(Integer id) {
        TourismEntity entity=repo.findByID(id);
        TourismDTO dto=new TourismDTO();
        dto.setTourID(entity.getTourID());
        dto.setDestination(entity.getDestination());
        dto.setVehicle(entity.getVehicle());
        dto.setStartDate(entity.getStartDate());
        dto.setPackagePrice(entity.getPackagePrice());
        dto.setEndDate(entity.getEndDate());
        dto.setStartPoint(entity.getStartPoint());
        dto.setVehicleNumber(entity.getVehicleNumber());
        dto.setNoOfPeople(entity.getNoOfPeople());

        return  dto;
    }

    @Override
    public String updateTourism(TourismDTO dto) {
        System.out.println("dto in update Service: "+dto);
        TourismEntity entity= new TourismEntity();
        BeanUtils.copyProperties(dto,entity);
        System.out.println("entity in updateTourism Service: "+entity);
        boolean isUpdated=repo.updateTourism(entity);
        if(isUpdated){
            return "data updated";
        }
        return "data not updated";
    }

    @Override
    public String deleteById(Integer id) {
        System.out.println("running deleteById in Service, id: "+id);
        boolean isDeleted= repo.deleteById(id);
        if(isDeleted){
            return "Data Deleted";
        }
        return "could not delete data";
    }
}