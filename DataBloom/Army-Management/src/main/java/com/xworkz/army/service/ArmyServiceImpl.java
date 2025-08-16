package com.xworkz.army.service;

import com.xworkz.army.dto.ArmyDTO;
import com.xworkz.army.entity.ArmyEntity;
import com.xworkz.army.repository.ArmyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArmyServiceImpl implements ArmyService {
    public ArmyServiceImpl() {
        System.out.println("Running in ArmyServiceImpl");
    }

    @Autowired
    private ArmyRepository armyRepository;

    @Override
    public boolean validate(ArmyDTO armyDTO) {
        if (armyDTO != null) {
            System.out.println("armyDTO is valid");
        } else {
            System.out.println("armyDTO is invalid");
        }
        if (armyDTO.getArmyName() != null) {
            System.out.println("Armyname is valid");
        } else {
            System.out.println("Armyname is invalid");
        }
        if (armyDTO.getCountry() != null) {
            System.out.println("Country is valid");
        } else {
            System.out.println("Country is invalid");
        }
        if (armyDTO.getCommanderName() != null) {
            System.out.println("Commandername is valid");
        } else {
            System.out.println("Commandername is invalid");
        }
        if (armyDTO.getBaseLocation() != null) {
            System.out.println("BaseLocation is valid");
        } else {
            System.out.println("BaseLocation is invalid");
        }
        if (armyDTO.getEstablishedDate() != null) {
            System.out.println("EstablishedDate is valid");
        } else {
            System.out.println("EstablishedDate is invalid");
        }

        ArmyEntity armyEntity = new ArmyEntity();
        armyEntity.setArmyName(armyDTO.getArmyName());
        armyEntity.setCountry(armyDTO.getCountry());
        armyEntity.setCommanderName(armyDTO.getCommanderName());
        armyEntity.setBaseLocation(armyDTO.getBaseLocation());
        armyEntity.setEstablishedDate(armyDTO.getEstablishedDate());

        System.out.println("save running in  ArmyServiceImpl" + armyEntity);
        return armyRepository.save(armyEntity);


    }

    @Override
    public List<ArmyDTO> fetchAll() {
        System.out.println("featchAll");
        List<ArmyEntity> ls = armyRepository.fetchAll();
        List<ArmyDTO> lst = ls.stream().map(entity -> {
            ArmyDTO armyDTO = new ArmyDTO();
            armyDTO.setArmyId(entity.getArmyId());
            armyDTO.setArmyName(entity.getArmyName());
            armyDTO.setCountry(entity.getCountry());
            armyDTO.setCommanderName(entity.getCommanderName());
            armyDTO.setBaseLocation(entity.getBaseLocation());
            armyDTO.setEstablishedDate(entity.getEstablishedDate());
            return armyDTO;
        }).collect(Collectors.toList());
        return lst;

    }

    @Override
    public ArmyDTO featchById(Integer id) {
        ArmyEntity army = armyRepository.featchById(id);
        ArmyDTO armyDTO = new ArmyDTO();
        BeanUtils.copyProperties(army,armyDTO);
        System.out.println("service: "+armyDTO);
        return armyDTO;
    }

    @Override
    public String updateArmyEntityById(ArmyDTO armyDTO) {
        System.out.println("updateArmyEntityById"+armyDTO);
        ArmyEntity armyEntity=new ArmyEntity();
        BeanUtils.copyProperties(armyDTO,armyEntity);
        boolean updated= armyRepository.updateArmyEntityById(armyEntity);
                if(updated){
                    return "updated";
                }
        return "not updated";
    }

    @Override
    public String deleteById(Integer id) {
        System.out.println("deletebyId"+id);
      //  ArmyEntity army=new ArmyEntity();
        boolean updated= armyRepository.deleteById(id);
        if(updated){
            return "deleted";
        }
        return "not deleted";
    }
}
