package com.xworkz.redbus.service;

import com.xworkz.redbus.entity.RedBusEntity;
import com.xworkz.redbus.repository.RedBusRepository;
import com.xworkz.redbus.repository.RedBusRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class RedBusServiceImpl implements RedBusService {

    private final RedBusRepository redBusRepository = new RedBusRepositoryImpl();

    @Override
    public void saveRedBus(RedBusEntity redbusEntity) {
        if (isValid(redbusEntity)) {
            try {
                redBusRepository.saveRedBus(redbusEntity);  // repository method should be void too
                System.out.println("RedBus entity saved successfully.");
            } catch (Exception e) {
                System.out.println("Failed to save RedBus entity.");
                e.printStackTrace();
            }
        } else {
            System.out.println("RedBus entity is invalid, cannot save.");
        }
    }

    private boolean isValid(RedBusEntity redbusEntity) {
        if (redbusEntity == null) {
            System.out.println("RedBusEntity is null");
            return false;
        }
        if (redbusEntity.getBusName() == null || redbusEntity.getBusName().isEmpty()) {
            System.out.println("BusName is invalid");
            return false;
        }
        if (redbusEntity.getPassengerName() == null || redbusEntity.getPassengerName().isEmpty()) {
            System.out.println("PassengerName is invalid");
            return false;
        }
        if (redbusEntity.getPassengerAge() == null || redbusEntity.getPassengerAge() <= 0) {
            System.out.println("PassengerAge is invalid");
            return false;
        }
        if (redbusEntity.getContact() == null || redbusEntity.getContact() <= 0L) {
            System.out.println("Contact is invalid");
            return false;
        }
        if (redbusEntity.getSeatNo() == null || redbusEntity.getSeatNo() <= 0) {
            System.out.println("SeatNo is invalid");
            return false;
        }
        return true;
    }

    @Override
    public RedBusEntity readRedBus(Integer busId) {
        return redBusRepository.readRedBus(busId);
    }

    @Override
    public RedBusEntity updateRedBus(RedBusEntity entity, Integer busId) {
        if (isValid(entity)) {
            return redBusRepository.updateRedBus(entity, busId);
        } else {
            System.out.println("Invalid RedBus entity, cannot update.");
            return null;
        }
    }

    @Override
    public RedBusEntity deleteRedBus(Integer busId) {
        return redBusRepository.deleteRedBus(busId);
    }

    @Override
    public RedBusEntity findByBusName(String busName) {
        return redBusRepository.findByBusName(busName);
    }

    @Override
    public RedBusEntity findByPassengerName(String passengerName) {
        return redBusRepository.findByPassengerName(passengerName);
    }

    @Override
    public RedBusEntity findByPassengerAge(Integer passengerAge) {
        return redBusRepository.findByPassengerAge(passengerAge);
    }

    @Override
    public RedBusEntity findByContact(Long contact) {
        return redBusRepository.findByContact(contact);
    }

    @Override
    public RedBusEntity findBySeatNo(Integer seatNo) {
        return redBusRepository.findBySeatNo(seatNo);
    }

    @Override
    public List<RedBusEntity> findAllRedBus() {
        return redBusRepository.findAllRedBus();
    }

    @Override
    public RedBusEntity updatePassengerNameByBusIdAndSeatNo(Integer busId, String passengerName, Integer seatNo) {
       return redBusRepository.updatePassengerNameByBusIdAndSeatNo(busId,passengerName,seatNo);
    }

    @Override
    public RedBusEntity updatePassengerAgeByBusIdAndPassengerName(Integer busId, Integer passengerAge, String passengerName) {
              return redBusRepository.updatePassengerAgeByBusIdAndPassengerName(busId, passengerAge, passengerName);
    }

    @Override
    public RedBusEntity updateContactByBusIdAndPassengerAge(Integer busId, Long contact, Integer passengerAge) {
               return redBusRepository.updateContactByBusIdAndPassengerAge(busId, contact, passengerAge);
    }

    @Override
    public List<String> findAllBusName() {
        return redBusRepository.findAllBusName();
    }

    @Override
    public List<String> findAllPassengerName() {
        return redBusRepository.findAllPassengerName();
    }

    @Override
    public List<Integer> findAllPassengerAge() {
        return redBusRepository.findAllPassengerAge();
    }

    @Override
    public List<Long> findAllContact() {
        return redBusRepository.findAllContact();
    }

    @Override
    public List<Integer> findAllSeatNo() {
        return redBusRepository.findAllPassengerAge();
    }

    @Override
    public List<Object[]> findByAllBusNameAndSeatNo() {
        return redBusRepository.findByAllBusNameAndSeatNo();
    }

    @Override
    public List<Object[]> findByAllPassengerNameAndPassengerAgeAndContact() {
        return redBusRepository.findByAllPassengerNameAndPassengerAgeAndContact();
    }
}
