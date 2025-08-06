package com.xworkz.redbus.repository;

import com.xworkz.redbus.entity.RedBusEntity;
import java.util.List;

public interface RedBusRepository {

    void saveRedBus(RedBusEntity redbusEntity);

    RedBusEntity readRedBus(Integer busId);

    RedBusEntity updateRedBus(RedBusEntity entity, Integer busId);

    RedBusEntity deleteRedBus(Integer busId);

    RedBusEntity findByBusName(String busName);

    RedBusEntity findByPassengerName(String passengerName);

    RedBusEntity findByPassengerAge(Integer passengerAge);

    RedBusEntity findByContact(Long contact);

    RedBusEntity findBySeatNo(Integer seatNo);

    List<RedBusEntity> findAllRedBus();

    RedBusEntity updatePassengerNameByBusIdAndSeatNo(Integer busId, String passengerName, Integer seatNo);

    RedBusEntity updatePassengerAgeByBusIdAndPassengerName(Integer busId, Integer passengerAge, String passengerName);

    RedBusEntity updateContactByBusIdAndPassengerAge(Integer busId, Long contact, Integer passengerAge);
}
