package com.xworkz.redbus.repository;

import com.xworkz.redbus.entity.RedBusEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class RedBusRepositoryImpl implements RedBusRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

    public RedBusRepositoryImpl() {
        System.out.println("Running in RedBusRepositoryImpl");
    }

    public static void closeFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    @Override
    public void saveRedBus(RedBusEntity redbusEntity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(redbusEntity);
            transaction.commit();
            System.out.println("Insertion done");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity readRedBus(Integer busId) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(RedBusEntity.class, busId);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity updateRedBus(RedBusEntity entity, Integer busId) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        RedBusEntity existingEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            existingEntity = entityManager.find(RedBusEntity.class, busId);
            if (existingEntity != null) {
                existingEntity.setBusName(entity.getBusName());
                existingEntity.setPassengerName(entity.getPassengerName());
                existingEntity.setPassengerAge(entity.getPassengerAge());
                existingEntity.setContact(entity.getContact());
                existingEntity.setSeatNo(entity.getSeatNo());
                entityManager.merge(existingEntity);
            }
            transaction.commit();
            return existingEntity;
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity deleteRedBus(Integer busId) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        RedBusEntity entity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entity = entityManager.find(RedBusEntity.class, busId);
            if (entity != null) {
                entityManager.remove(entity);
            }
            transaction.commit();
            return entity;
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity findByBusName(String busName) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createNamedQuery("getByBusName", RedBusEntity.class)
                    .setParameter("name", busName)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No RedBusEntity found with busName: " + busName);
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity findByPassengerName(String passengerName) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createNamedQuery("getByPassengerName", RedBusEntity.class)
                    .setParameter("passenger_name", passengerName)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No RedBusEntity found with passengerName: " + passengerName);
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity findByPassengerAge(Integer passengerAge) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createNamedQuery("getByPassengerAge", RedBusEntity.class)
                    .setParameter("passenger_age", passengerAge)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No RedBusEntity found with passengerAge: " + passengerAge);
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity findByContact(Long contact) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createNamedQuery("getByContact", RedBusEntity.class)
                    .setParameter("contact", contact)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No RedBusEntity found with contact: " + contact);
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity findBySeatNo(Integer seatNo) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createNamedQuery("getBySeatNo", RedBusEntity.class)
                    .setParameter("seat_no", seatNo)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No RedBusEntity found with seatNo: " + seatNo);
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<RedBusEntity> findAllRedBus() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<RedBusEntity> query = entityManager.createNamedQuery("getByAllRedbusEntity", RedBusEntity.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity updatePassengerNameByBusIdAndSeatNo(Integer busId, String passengerName, Integer seatNo) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            int updatedCount = entityManager.createNamedQuery("updatePassengerNameByBusIdAndSeatNo")
                    .setParameter("passengerName", passengerName)
                    .setParameter("busId", busId)
                    .setParameter("seatNo", seatNo)
                    .executeUpdate();
            transaction.commit();
            return updatedCount > 0 ? entityManager.find(RedBusEntity.class, busId) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity updatePassengerAgeByBusIdAndPassengerName(Integer busId, Integer passengerAge, String passengerName) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            int updatedCount = entityManager.createNamedQuery("updatePassengerAgeByBusIdAndPassengerName")
                    .setParameter("passengerAge", passengerAge)
                    .setParameter("busId", busId)
                    .setParameter("passengerName", passengerName)
                    .executeUpdate();
            transaction.commit();
            return updatedCount > 0 ? entityManager.find(RedBusEntity.class, busId) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public RedBusEntity updateContactByBusIdAndPassengerAge(Integer busId, Long contact, Integer passengerAge) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            int updatedCount = entityManager.createNamedQuery("updateContactByBusIdAndPassengerAge")
                    .setParameter("contact", contact)
                    .setParameter("busId", busId)
                    .setParameter("passengerAge", passengerAge)
                    .executeUpdate();
            transaction.commit();
            return updatedCount > 0 ? entityManager.find(RedBusEntity.class, busId) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
