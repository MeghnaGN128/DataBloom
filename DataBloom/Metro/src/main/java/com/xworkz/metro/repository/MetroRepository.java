package com.xworkz.metro.repository;

import com.xworkz.metro.entity.MetroEntity;

import java.util.List;

public interface MetroRepository {

    void saveMetro(MetroEntity metroEntity);

    MetroEntity readMetro(Integer metroId);

    MetroEntity updateMetro(MetroEntity metroEntity, Integer metroId);

    MetroEntity deleteMetro(Integer metroId);

    MetroEntity findByMetroName(String metroName);

    MetroEntity findByOperator(String operator);

    MetroEntity findByTotalRoutes(Integer totalRoutes);

    List<MetroEntity> findAllMetros();

    MetroEntity updateOperatorById(Integer metroId, String operator);

    MetroEntity updateTotalRoutesAndOperatorByName(String metroName, Integer totalRoutes, String operator);

    MetroEntity updateMetroNameByOperatorAndRoutes(String operator, Integer totalRoutes, String metroName);
}
