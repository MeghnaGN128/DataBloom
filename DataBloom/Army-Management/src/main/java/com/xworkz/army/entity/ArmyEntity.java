package com.xworkz.army.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
@NamedQuery(name="fetchAll",query = "select a from ArmyEntity a ")
@NamedQuery(name="featchBYId", query = "select i from ArmyEntity i where i.armyId=:id")
@NamedQuery(name="updateArmyEntityById",
        query = "update ArmyEntity r set r.armyName=:armyName,r.country=:country,r.commanderName=:commanderName,r.baseLocation=:baseLocation,r.establishedDate=:establishedDate where r.armyId=:armyId")
@NamedQuery(name = "deleteById" ,query = "delete from ArmyEntity m where m.armyId=:armyId")
@Table(name="army_info")
public class ArmyEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="army_Id")
    private Integer armyId;
@Column(name = "army_Name")
    private String armyName;
@Column(name = "country")
    private String country;
@Column(name = "commander_Name")
    private String commanderName;
@Column(name = "base_Location")
    private String baseLocation;
@Column(name = "established_Date")
    private String establishedDate;
}
