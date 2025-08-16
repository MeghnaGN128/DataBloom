package com.xworkz.army.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class ArmyDTO {
    private Integer armyId;
    private String armyName;
    private String country;
    private String commanderName;
    private String baseLocation;
    private String establishedDate;
}
