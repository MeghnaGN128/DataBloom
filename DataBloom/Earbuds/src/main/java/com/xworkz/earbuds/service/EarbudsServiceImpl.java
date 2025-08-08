package com.xworkz.earbuds.service;

import com.xworkz.earbuds.dto.EarbudsDTO;
import com.xworkz.earbuds.entity.EarbudsEntity;
import com.xworkz.earbuds.repository.EarbudsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarbudsServiceImpl implements EarbudsService{

    public EarbudsServiceImpl(){
        System.out.println("Running in EarbudsServiceImpl");
    }

    @Autowired
    private EarbudsRepository earbudsRepository;

    @Override
    public boolean validate(EarbudsDTO earbudsDTO) {
        if(earbudsDTO!=null){
            System.out.println("earbuds data is valid");
        }
        else {
            System.out.println("Earbuds datae is not valid");
        }if(earbudsDTO.getBrand()!=null){
            System.out.println("brand is valid");
        }else {
            System.out.println("brand is invalid");
        }if (earbudsDTO.getPrice()>0.0){
            System.out.println("price is valid");
        }else {
            System.out.println("price is invalid");
        }if(earbudsDTO.getPlayingHours()>0){
            System.out.println("hours is valid");
        }else {
            System.out.println("hours is invalid");
        }if(earbudsDTO.getChargingType()!=null){
            System.out.println("chargingtype is valid");
        }else {
            System.out.println("chargingtype is invalid");
        }
        EarbudsEntity earbudsEntity=new EarbudsEntity();
        earbudsEntity.setBrand(earbudsDTO.getBrand());
        earbudsEntity.setPrice(earbudsDTO.getPrice());
        earbudsEntity.setPlayingHours(earbudsDTO.getPlayingHours());
        earbudsEntity.setChargingType(earbudsDTO.getChargingType());
        System.out.println("earbudsentity:"+earbudsEntity);
        return earbudsRepository.save(earbudsEntity);
    }
}
