package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;
import java.util.List;

public interface TourismRepository {

    boolean saveTourism(TourismEntity entity);

    List<TourismEntity> fetchAll();

    TourismEntity findByID(Integer id);

    boolean updateTourism(TourismEntity entity);

    boolean deleteById(Integer id);
}

