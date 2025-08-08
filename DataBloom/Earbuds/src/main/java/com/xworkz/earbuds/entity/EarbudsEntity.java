package com.xworkz.earbuds.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@RequiredArgsConstructor
@Table(name="earbuds_zone")
public class EarbudsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "earbuds_Id")
    private Integer earbudsId;

    @Column(name="earbuds_brand")
    private String brand;

    @Column(name="earbuds_price")
    private  double price;

    @Column(name="earbuds_playing_Hours")
    private int playingHours;

    @Column(name="earbuds_charging_Type")
    private String chargingType;
}
