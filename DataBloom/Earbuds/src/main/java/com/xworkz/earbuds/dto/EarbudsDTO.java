package com.xworkz.earbuds.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class EarbudsDTO {
    private Integer earbudsId;
    private String brand;
    private  double price;
    private int playingHours;
    private String chargingType;


}
