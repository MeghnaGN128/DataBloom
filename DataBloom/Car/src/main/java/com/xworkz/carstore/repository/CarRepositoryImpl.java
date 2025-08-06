package com.xworkz.carstore.repository;

import com.xworkz.carstore.entity.CarEntity;

import javax.persistence.*;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("x-workz");

    @Override
    public void saveCar(CarEntity carEntity) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(carEntity);
            tx.commit();
            System.out.println("Car saved successfully");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    @Override
    public CarEntity readCar(Integer carId) {
        EntityManager em = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            car = em.find(CarEntity.class, carId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity updateCar(CarEntity entity, Integer carId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            car = em.find(CarEntity.class, carId);
            if (car != null) {
                car.setMake(entity.getMake());
                car.setModel(entity.getModel());
                car.setYear(entity.getYear());
                car.setPrice(entity.getPrice());
                em.merge(car);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity deleteCar(Integer carId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            car = em.find(CarEntity.class, carId);
            if (car != null) {
                em.remove(car);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity findByMake(String make) {
        EntityManager em = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            car = em.createNamedQuery("CarEntity.findByMake", CarEntity.class)
                    .setParameter("make", make)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No car found with make: " + make);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity findByModel(String model) {
        EntityManager em = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            car = em.createNamedQuery("CarEntity.findByModel", CarEntity.class)
                    .setParameter("model", model)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No car found with model: " + model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity findByYear(Integer year) {
        EntityManager em = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            car = em.createNamedQuery("CarEntity.findByYear", CarEntity.class)
                    .setParameter("year", year)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No car found with year: " + year);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public CarEntity findByPrice(Double price) {
        EntityManager em = null;
        CarEntity car = null;
        try {
            em = entityManagerFactory.createEntityManager();
            car = em.createNamedQuery("CarEntity.findByPrice", CarEntity.class)
                    .setParameter("price", price)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No car found with price: " + price);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return car;
    }

    @Override
    public List<CarEntity> findAllCars() {
        EntityManager em = null;
        List<CarEntity> cars = null;
        try {
            em = entityManagerFactory.createEntityManager();
            cars = em.createNamedQuery("CarEntity.findAll", CarEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return cars;
    }

    @Override
    public CarEntity updatePriceById(Integer carId, Double price) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("CarEntity.updatePriceById")
                    .setParameter("price", price)
                    .setParameter("carId", carId)
                    .executeUpdate();
            tx.commit();
            return em.find(CarEntity.class, carId);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }

    @Override
    public CarEntity updateModelAndYearByMake(String make, String model, Integer year) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("CarEntity.updateModelAndYearByMake")
                    .setParameter("model", model)
                    .setParameter("year", year)
                    .setParameter("make", make)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("CarEntity.findByMake", CarEntity.class)
                    .setParameter("make", make)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }

    @Override
    public CarEntity updateMakeByModelAndPrice(String model, Double price, String make) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("CarEntity.updateMakeByModelAndPrice")
                    .setParameter("make", make)
                    .setParameter("model", model)
                    .setParameter("price", price)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("CarEntity.findByMake", CarEntity.class)
                    .setParameter("make", make)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }
}
