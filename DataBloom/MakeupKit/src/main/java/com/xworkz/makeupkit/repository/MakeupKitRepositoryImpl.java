package com.xworkz.makeupkit.repository;

import com.xworkz.makeupkit.entity.MakeupKitEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class MakeupKitRepositoryImpl implements MakeupKitRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("x-workz");

    @Override
    public void saveMakeupKit(MakeupKitEntity makeupKitEntity) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(makeupKitEntity);
            tx.commit();
            System.out.println("MakeupKit saved successfully");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    @Override
    public MakeupKitEntity readMakeupKit(Integer makeupKitId) {
        EntityManager em = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            makeupKit = em.find(MakeupKitEntity.class, makeupKitId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public MakeupKitEntity updateMakeupKit(MakeupKitEntity entity, Integer makeupKitId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            makeupKit = em.find(MakeupKitEntity.class, makeupKitId);
            if (makeupKit != null) {
                makeupKit.setBrand(entity.getBrand());
                makeupKit.setType(entity.getType());
                makeupKit.setExpiryDate(entity.getExpiryDate());
                makeupKit.setPrice(entity.getPrice());
                em.merge(makeupKit);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public MakeupKitEntity deleteMakeupKit(Integer makeupKitId) {
        EntityManager em = null;
        EntityTransaction tx = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            makeupKit = em.find(MakeupKitEntity.class, makeupKitId);
            if (makeupKit != null) {
                em.remove(makeupKit);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public MakeupKitEntity findByBrand(String brand) {
        EntityManager em = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            makeupKit = em.createNamedQuery("MakeupKitEntity.findByBrand", MakeupKitEntity.class)
                    .setParameter("brand", brand)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No MakeupKit found with brand: " + brand);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public MakeupKitEntity findByType(String type) {
        EntityManager em = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            makeupKit = em.createNamedQuery("MakeupKitEntity.findByType", MakeupKitEntity.class)
                    .setParameter("type", type)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No MakeupKit found with type: " + type);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public MakeupKitEntity findByPrice(Double price) {
        EntityManager em = null;
        MakeupKitEntity makeupKit = null;
        try {
            em = entityManagerFactory.createEntityManager();
            makeupKit = em.createNamedQuery("MakeupKitEntity.findByPrice", MakeupKitEntity.class)
                    .setParameter("price", price)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No MakeupKit found with price: " + price);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return makeupKit;
    }

    @Override
    public List<MakeupKitEntity> findAllMakeupKits() {
        EntityManager em = null;
        List<MakeupKitEntity> kits = null;
        try {
            em = entityManagerFactory.createEntityManager();
            kits = em.createNamedQuery("MakeupKitEntity.findAll", MakeupKitEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return kits;
    }

    @Override
    public MakeupKitEntity updatePriceById(Integer makeupKitId, Double price) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("MakeupKitEntity.updatePriceById")
                    .setParameter("price", price)
                    .setParameter("makeupKitId", makeupKitId)
                    .executeUpdate();
            tx.commit();
            return em.find(MakeupKitEntity.class, makeupKitId);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return null;
    }

    @Override
    public MakeupKitEntity updateTypeAndExpiryByBrand(String brand, String type, LocalDate expiryDate) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("MakeupKitEntity.updateTypeAndExpiryByBrand")
                    .setParameter("type", type)
                    .setParameter("expiryDate", expiryDate)
                    .setParameter("brand", brand)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("MakeupKitEntity.findByBrand", MakeupKitEntity.class)
                    .setParameter("brand", brand)
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
    public MakeupKitEntity updateBrandByTypeAndPrice(String type, Double price, String brand) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = entityManagerFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updated = em.createNamedQuery("MakeupKitEntity.updateBrandByTypeAndPrice")
                    .setParameter("brand", brand)
                    .setParameter("type", type)
                    .setParameter("price", price)
                    .executeUpdate();
            tx.commit();
            return em.createNamedQuery("MakeupKitEntity.findByBrand", MakeupKitEntity.class)
                    .setParameter("brand", brand)
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
