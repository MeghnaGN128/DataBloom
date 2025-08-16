package com.xworkz.army.service;

import com.xworkz.army.dto.ArmyDTO;
import java.util.List;

public interface ArmyService {
    boolean validate(ArmyDTO armyDTO);
    List<ArmyDTO> fetchAll();
    ArmyDTO featchById(Integer id);
    String updateArmyEntityById(ArmyDTO armyDTO);
    String deleteById(Integer id);
}
