package com.xworkz.makeupkit.service;

import com.xworkz.makeupkit.entity.MakeupKitEntity;
import com.xworkz.makeupkit.repository.MakeupKitRepository;
import com.xworkz.makeupkit.repository.MakeupKitRepositoryImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class MakeupKitServiceImpl implements MakeupKitService {

    private final MakeupKitRepository makeupKitRepository = new MakeupKitRepositoryImpl();

    private boolean isValid(MakeupKitEntity makeupKit) {
        if (makeupKit == null) {
            System.out.println("MakeupKitEntity is null");
            return false;
        }
        if (makeupKit.getBrand() == null || makeupKit.getBrand().isEmpty()) {
            System.out.println("Brand is invalid");
            return false;
        }
        if (makeupKit.getType() == null || makeupKit.getType().isEmpty()) {
            System.out.println("Type is invalid");
            return false;
        }
        if (makeupKit.getPrice() == null || makeupKit.getPrice() <= 0) {
            System.out.println("Price is invalid");
            return false;
        }
        // expiryDate can be null or future date check if you want.
        return true;
    }

    @Override
    public void saveMakeupKit(MakeupKitEntity makeupKitEntity) {
        if (isValid(makeupKitEntity)) {
            try {
                makeupKitRepository.saveMakeupKit(makeupKitEntity);
                System.out.println("MakeupKit saved successfully.");
            } catch (Exception e) {
                System.out.println("Failed to save MakeupKit.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid MakeupKitEntity, cannot save.");
        }
    }

    @Override
    public MakeupKitEntity readMakeupKit(Integer makeupKitId) {
        if (makeupKitId == null || makeupKitId <= 0) {
            System.out.println("Invalid makeupKitId");
            return null;
        }
        return makeupKitRepository.readMakeupKit(makeupKitId);
    }

    @Override
    public MakeupKitEntity updateMakeupKit(MakeupKitEntity makeupKitEntity, Integer makeupKitId) {
        if (isValid(makeupKitEntity) && makeupKitId != null && makeupKitId > 0) {
            return makeupKitRepository.updateMakeupKit(makeupKitEntity, makeupKitId);
        }
        System.out.println("Invalid input for updateMakeupKit");
        return null;
    }

    @Override
    public MakeupKitEntity deleteMakeupKit(Integer makeupKitId) {
        if (makeupKitId == null || makeupKitId <= 0) {
            System.out.println("Invalid makeupKitId for deletion");
            return null;
        }
        return makeupKitRepository.deleteMakeupKit(makeupKitId);
    }

    @Override
    public MakeupKitEntity findByBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("Invalid brand");
            return null;
        }
        return makeupKitRepository.findByBrand(brand);
    }

    @Override
    public MakeupKitEntity findByType(String type) {
        if (type == null || type.isEmpty()) {
            System.out.println("Invalid type");
            return null;
        }
        return makeupKitRepository.findByType(type);
    }

    @Override
    public MakeupKitEntity findByPrice(Double price) {
        if (price == null || price <= 0) {
            System.out.println("Invalid price");
            return null;
        }
        return makeupKitRepository.findByPrice(price);
    }

    @Override
    public List<MakeupKitEntity> findAllMakeupKits() {
        List<MakeupKitEntity> list = makeupKitRepository.findAllMakeupKits();
        return list != null ? list : Collections.emptyList();
    }

    @Override
    public MakeupKitEntity updatePriceById(Integer makeupKitId, Double price) {
        if (makeupKitId == null || makeupKitId <= 0 || price == null || price <= 0) {
            System.out.println("Invalid input to updatePriceById");
            return null;
        }
        return makeupKitRepository.updatePriceById(makeupKitId, price);
    }

    @Override
    public MakeupKitEntity updateTypeAndExpiryByBrand(String brand, String type, LocalDate expiryDate) {
        if (brand == null || brand.isEmpty() || type == null || type.isEmpty() || expiryDate == null) {
            System.out.println("Invalid input to updateTypeAndExpiryByBrand");
            return null;
        }
        return makeupKitRepository.updateTypeAndExpiryByBrand(brand, type, expiryDate);
    }

    @Override
    public MakeupKitEntity updateBrandByTypeAndPrice(String type, Double price, String brand) {
        if (type == null || type.isEmpty() || price == null || price <= 0 || brand == null || brand.isEmpty()) {
            System.out.println("Invalid input to updateBrandByTypeAndPrice");
            return null;
        }
        return makeupKitRepository.updateBrandByTypeAndPrice(type, price, brand);
    }
}
