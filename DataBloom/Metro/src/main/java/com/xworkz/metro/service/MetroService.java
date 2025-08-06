package com.xworkz.metro.service;

import com.xworkz.metro.entity.MetroEntity;
import java.util.List;

public interface MetroService {

    void saveMetro(MetroEntity metroEntity);

    MetroEntity readMetro(Integer metroId);

    MetroEntity updateMetro(MetroEntity metroEntity, Integer metroId);

    MetroEntity deleteMetro(Integer metroId);

    MetroEntity findByMetroName(String metroName);

    MetroEntity findByOperator(String operator);

    MetroEntity findByTotalRoutes(Integer totalRoutes);

    List<MetroEntity> findAllMetros();

    MetroEntity updateOperatorByMetroId(Integer metroId, String operator);

    MetroEntity updateTotalRoutesAndOperatorByMetroName(String metroName, Integer totalRoutes, String operator);

    MetroEntity updateMetroNameByOperatorAndTotalRoutes(String operator, Integer totalRoutes, String metroName);
}
