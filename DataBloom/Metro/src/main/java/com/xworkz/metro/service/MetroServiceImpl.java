package com.xworkz.metro.service;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.repository.MetroRepository;
import com.xworkz.metro.repository.MetroRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class MetroServiceImpl implements MetroService {

    private final MetroRepository metroRepository = new MetroRepositoryImpl();

    private boolean isValid(MetroEntity metro) {
        if (metro == null) {
            System.out.println("MetroEntity is null");
            return false;
        }
        if (metro.getMetroName() == null || metro.getMetroName().isEmpty()) {
            System.out.println("MetroName is invalid");
            return false;
        }
        if (metro.getOperator() == null || metro.getOperator().isEmpty()) {
            System.out.println("Operator is invalid");
            return false;
        }
        if (metro.getTotalRoutes() == null || metro.getTotalRoutes() <= 0) {
            System.out.println("TotalRoutes is invalid");
            return false;
        }
        return true;
    }

    @Override
    public void saveMetro(MetroEntity metroEntity) {
        if (isValid(metroEntity)) {
            try {
                metroRepository.saveMetro(metroEntity);
                System.out.println("Metro saved successfully.");
            } catch (Exception e) {
                System.out.println("Failed to save Metro.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid MetroEntity, cannot save.");
        }
    }

    @Override
    public MetroEntity readMetro(Integer metroId) {
        if (metroId == null || metroId <= 0) {
            System.out.println("Invalid metroId");
            return null;
        }
        return metroRepository.readMetro(metroId);
    }

    @Override
    public MetroEntity updateMetro(MetroEntity metroEntity, Integer metroId) {
        if (isValid(metroEntity) && metroId != null && metroId > 0) {
            return metroRepository.updateMetro(metroEntity, metroId);
        }
        System.out.println("Invalid input for updateMetro");
        return null;
    }

    @Override
    public MetroEntity deleteMetro(Integer metroId) {
        if (metroId == null || metroId <= 0) {
            System.out.println("Invalid metroId for deletion");
            return null;
        }
        return metroRepository.deleteMetro(metroId);
    }

    @Override
    public MetroEntity findByMetroName(String metroName) {
        if (metroName == null || metroName.isEmpty()) {
            System.out.println("Invalid metroName");
            return null;
        }
        return metroRepository.findByMetroName(metroName);
    }

    @Override
    public MetroEntity findByOperator(String operator) {
        if (operator == null || operator.isEmpty()) {
            System.out.println("Invalid operator");
            return null;
        }
        return metroRepository.findByOperator(operator);
    }

    @Override
    public MetroEntity findByTotalRoutes(Integer totalRoutes) {
        if (totalRoutes == null || totalRoutes <= 0) {
            System.out.println("Invalid totalRoutes");
            return null;
        }
        return metroRepository.findByTotalRoutes(totalRoutes);
    }

    @Override
    public List<MetroEntity> findAllMetros() {
        List<MetroEntity> list = metroRepository.findAllMetros();
        return list != null ? list : Collections.emptyList();
    }

    @Override
    public MetroEntity updateOperatorByMetroId(Integer metroId, String operator) {
        if (metroId == null || metroId <= 0 || operator == null || operator.isEmpty()) {
            System.out.println("Invalid input for updateOperatorByMetroId");
            return null;
        }
        return metroRepository.updateOperatorById(metroId, operator);
    }

    @Override
    public MetroEntity updateTotalRoutesAndOperatorByMetroName(String metroName, Integer totalRoutes, String operator) {
        if (metroName == null || metroName.isEmpty() || totalRoutes == null || totalRoutes <= 0
                || operator == null || operator.isEmpty()) {
            System.out.println("Invalid input for updateTotalRoutesAndOperatorByMetroName");
            return null;
        }
        return metroRepository.updateTotalRoutesAndOperatorByName(metroName, totalRoutes, operator);
    }

    @Override
    public MetroEntity updateMetroNameByOperatorAndTotalRoutes(String operator, Integer totalRoutes, String metroName) {
        if (operator == null || operator.isEmpty() || totalRoutes == null || totalRoutes <= 0
                || metroName == null || metroName.isEmpty()) {
            System.out.println("Invalid input for updateMetroNameByOperatorAndTotalRoutes");
            return null;
        }
        return metroRepository.updateMetroNameByOperatorAndRoutes(operator, totalRoutes, metroName);
    }
}
