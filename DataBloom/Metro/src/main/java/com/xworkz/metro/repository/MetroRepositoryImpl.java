package com.xworkz.metro.repository;

import com.xworkz.metro.entity.MetroEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MetroRepositoryImpl implements MetroRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("x-workz");

    public static void closeFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen())
            entityManagerFactory.close();
    }

    @Override
    public void saveMetro(MetroEntity metroEntity) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(metroEntity);
            tx.commit();
            System.out.println("Metro saved successfully");
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    @Override
    public MetroEntity readMetro(Integer metroId) {
        EntityManager entityManager = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            metro = entityManager.find(MetroEntity.class, metroId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public MetroEntity updateMetro(MetroEntity entity, Integer metroId) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            metro = entityManager.find(MetroEntity.class, metroId);
            if (metro != null) {
                metro.setMetroName(entity.getMetroName());
                metro.setOperator(entity.getOperator());
                metro.setTotalRoutes(entity.getTotalRoutes());
                entityManager.merge(metro);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public MetroEntity deleteMetro(Integer metroId) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            metro = entityManager.find(MetroEntity.class, metroId);
            if (metro != null) {
                entityManager.remove(metro);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public MetroEntity findByMetroName(String metroName) {
        EntityManager entityManager = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            metro = entityManager.createNamedQuery("findMetroByName", MetroEntity.class)
                    .setParameter("name", metroName)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No Metro found with metroName: " + metroName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public MetroEntity findByOperator(String operator) {
        EntityManager entityManager = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            metro = entityManager.createNamedQuery("findMetroByOperator", MetroEntity.class)
                    .setParameter("operator", operator)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No Metro found with operator: " + operator);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public MetroEntity findByTotalRoutes(Integer totalRoutes) {
        EntityManager entityManager = null;
        MetroEntity metro = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            metro = entityManager.createNamedQuery("findMetroByTotalRoutes", MetroEntity.class)
                    .setParameter("totalRoutes", totalRoutes)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No Metro found with totalRoutes: " + totalRoutes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return metro;
    }

    @Override
    public List<MetroEntity> findAllMetros() {
        EntityManager entityManager = null;
        List<MetroEntity> list = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<MetroEntity> query = entityManager.createNamedQuery("findAllMetros", MetroEntity.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return list;
    }

    @Override
    public MetroEntity updateOperatorById(Integer metroId, String operator) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.createNamedQuery("updateOperatorById")
                    .setParameter("operator", operator)
                    .setParameter("metroId", metroId)
                    .executeUpdate();
            tx.commit();
            return entityManager.find(MetroEntity.class, metroId);
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return null;
    }

    @Override
    public MetroEntity updateTotalRoutesAndOperatorByName(String metroName, Integer totalRoutes, String operator) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.createNamedQuery("updateTotalRoutesAndOperatorByName")
                    .setParameter("totalRoutes", totalRoutes)
                    .setParameter("operator", operator)
                    .setParameter("metroName", metroName)
                    .executeUpdate();
            tx.commit();
            return entityManager.createNamedQuery("findMetroByName", MetroEntity.class)
                    .setParameter("name", metroName)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return null;
    }

    @Override
    public MetroEntity updateMetroNameByOperatorAndRoutes(String operator, Integer totalRoutes, String metroName) {
        EntityManager entityManager = null;
        EntityTransaction tx = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.createNamedQuery("updateMetroNameByOperatorAndRoutes")
                    .setParameter("metroName", metroName)
                    .setParameter("operator", operator)
                    .setParameter("totalRoutes", totalRoutes)
                    .executeUpdate();
            tx.commit();
            return entityManager.createNamedQuery("findMetroByName", MetroEntity.class)
                    .setParameter("name", metroName)
                    .getSingleResult();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return null;
    }

    @Override
    public List<Integer> findAllMetroIds() {
        EntityManager em = null;
        List<Integer> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findAllMetroIds").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;

    }

    @Override
    public List<String> findAllMetroNames() {
        EntityManager em = null;
        List<String> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findAllMetroNames").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<String> findAllOperators() {
        EntityManager em = null;
        List<String> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findAllOperators").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<Integer> findAllTotalRoutes() {
        EntityManager em = null;
        List<Integer> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findAllTotalRoutes").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<String[]> findAllMetroNameAndOperator() {
        EntityManager em = null;
        List<String[]> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findAllMetroNameAndOperator").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<Object[]> findByAllOperatorAndTotalRoutesAndMetroName() {
        EntityManager em = null;
        List<Object[]> list = null;
        try {
            list = entityManagerFactory.createEntityManager().createNamedQuery("findByAllOperatorAndTotalRoutesAndMetroName").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return list;
    }
}
