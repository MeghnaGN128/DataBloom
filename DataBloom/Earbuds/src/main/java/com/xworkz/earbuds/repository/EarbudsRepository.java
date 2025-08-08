package com.xworkz.earbuds.repository;

import com.xworkz.earbuds.dto.EarbudsDTO;
import com.xworkz.earbuds.entity.EarbudsEntity;

public interface EarbudsRepository {
    boolean save(EarbudsEntity earbudsEntity);
}
