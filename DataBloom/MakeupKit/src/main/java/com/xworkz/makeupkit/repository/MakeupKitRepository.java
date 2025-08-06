package com.xworkz.makeupkit.repository;

import com.xworkz.makeupkit.entity.MakeupKitEntity;

import java.time.LocalDate;
import java.util.List;

public interface MakeupKitRepository {

    void saveMakeupKit(MakeupKitEntity makeupKitEntity);

    MakeupKitEntity readMakeupKit(Integer makeupKitId);

    MakeupKitEntity updateMakeupKit(MakeupKitEntity makeupKitEntity, Integer makeupKitId);

    MakeupKitEntity deleteMakeupKit(Integer makeupKitId);

    MakeupKitEntity findByBrand(String brand);

    MakeupKitEntity findByType(String type);

    MakeupKitEntity findByPrice(Double price);

    List<MakeupKitEntity> findAllMakeupKits();

    MakeupKitEntity updatePriceById(Integer makeupKitId, Double price);

    MakeupKitEntity updateTypeAndExpiryByBrand(String brand, String type, LocalDate expiryDate);

    MakeupKitEntity updateBrandByTypeAndPrice(String type, Double price, String brand);
}
