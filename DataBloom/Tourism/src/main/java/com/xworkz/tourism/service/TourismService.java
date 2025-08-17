package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDTO;
import java.util.List;

public interface TourismService {

    boolean saveTourism(TourismDTO dto);

    List<TourismDTO> fetchAll();

    TourismDTO findByID(Integer id);

    String updateTourism(TourismDTO dto);

    String deleteById(Integer id);
}

