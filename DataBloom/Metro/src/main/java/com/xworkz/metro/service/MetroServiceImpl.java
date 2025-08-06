package com.xworkz.metro.service;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.repository.MetroRepository;
import com.xworkz.metro.repository.MetroRepositoryImpl;

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
        return metroRepository.readMetro(metroId);
    }

    @Override
    public MetroEntity updateMetro(MetroEntity metroEntity, Integer metroId) {
        return metroRepository.updateMetro(metroEntity, metroId);
    }

    @Override
    public MetroEntity deleteMetro(Integer metroId) {
        return metroRepository.deleteMetro(metroId);
    }

    @Override
    public MetroEntity findByMetroName(String metroName) {
        return metroRepository.findByMetroName(metroName);
    }

    @Override
    public MetroEntity findByOperator(String operator) {
        return metroRepository.findByOperator(operator);
    }

    @Override
    public MetroEntity findByTotalRoutes(Integer totalRoutes) {
        return metroRepository.findByTotalRoutes(totalRoutes);
    }

    @Override
    public List<MetroEntity> findAllMetros() {
        return metroRepository.findAllMetros();
    }

    @Override
    public MetroEntity updateOperatorByMetroId(Integer metroId, String operator) {
        return metroRepository.updateOperatorById(metroId, operator);
    }

    @Override
    public MetroEntity updateTotalRoutesAndOperatorByMetroName(String metroName, Integer totalRoutes, String operator) {
        return metroRepository.updateTotalRoutesAndOperatorByName(metroName, totalRoutes, operator);
    }

    @Override
    public MetroEntity updateMetroNameByOperatorAndTotalRoutes(String operator, Integer totalRoutes, String metroName) {
        return metroRepository.updateMetroNameByOperatorAndRoutes(operator, totalRoutes, metroName);
    }

    @Override
    public List<Integer> findAllMetroIds() {
        return metroRepository.findAllMetroIds();
    }

    @Override
    public List<String> findAllMetroNames() {
        return metroRepository.findAllMetroNames();
    }

    @Override
    public List<String> findAllOperators() {
        return metroRepository.findAllOperators();
    }

    @Override
    public List<Integer> findAllTotalRoutes() {
        return metroRepository.findAllTotalRoutes();
    }

    @Override
    public List<String[]> findAllMetroNameAndOperator() {
        return metroRepository.findAllMetroNameAndOperator();
    }

    @Override
    public List<Object[]> findByAllOperatorAndTotalRoutesAndMetroName() {
        return metroRepository.findByAllOperatorAndTotalRoutesAndMetroName();
    }
}
