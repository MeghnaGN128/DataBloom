package com.xworkz.army.repository;

import com.xworkz.army.dto.ArmyDTO;
import com.xworkz.army.entity.ArmyEntity;

import java.util.List;

public interface ArmyRepository {
    boolean save(ArmyEntity armyEntity);
    List<ArmyEntity> fetchAll();
    ArmyEntity featchById(Integer id);
    boolean updateArmyEntityById(ArmyEntity armyEntity);
    boolean deleteById(Integer id);
}
