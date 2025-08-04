package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class ApplicationRepositoryImpl implements ApplicationRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("x-workz");

    public static void closeFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(applicationEntity);
            entityTransaction.commit();
            System.out.println("Insertion done");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.find(ApplicationEntity.class, id);
            // Removed internal print statement here to avoid duplicate output
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity entity, Integer id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            applicationEntity = entityManager.find(ApplicationEntity.class, id);
            if (applicationEntity != null) {
                applicationEntity.setApplicationName(entity.getApplicationName());
                applicationEntity.setApplicationSize(entity.getApplicationSize());
                applicationEntity.setCompany(entity.getCompany());
                applicationEntity.setNoOfUsers(entity.getNoOfUsers());
                applicationEntity.setRatings(entity.getRatings());
                applicationEntity.setLaunchDate(entity.getLaunchDate());
                entityManager.merge(applicationEntity);
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            applicationEntity = entityManager.find(ApplicationEntity.class, id);
            if (applicationEntity != null) {
                entityManager.remove(applicationEntity);
            }
            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findApplicationByName(String name) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findByName", ApplicationEntity.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("findByName: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for name: " + name);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findBySize(String size) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findBySize", ApplicationEntity.class)
                    .setParameter("size", size)
                    .getSingleResult();
            System.out.println("findBySize: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for size: " + size);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByCompany(String company) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findByCompany", ApplicationEntity.class)
                    .setParameter("company", company)
                    .getSingleResult();
            System.out.println("findByCompany: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for company: " + company);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByUsers(Integer users) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findByUsers", ApplicationEntity.class)
                    .setParameter("users", users)
                    .getSingleResult();
            System.out.println("findByUsers: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for users: " + users);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByRatings(Float ratings) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findByRatings", ApplicationEntity.class)
                    .setParameter("ratings", ratings)
                    .getSingleResult();
            System.out.println("findByRatings: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for ratings: " + ratings);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByDate(LocalDate date) {
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.createNamedQuery("findByDate", ApplicationEntity.class)
                    .setParameter("date", date)
                    .getSingleResult();
            System.out.println("findByDate: " + applicationEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for date: " + date);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return applicationEntity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ApplicationEntity> findByAll() {
        EntityManager entityManager = null;
        List<ApplicationEntity> list = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("applicationAll");
            list = query.getResultList();
            System.out.println("findByAll: " + list.size() + " records fetched.");
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }
        }
        return list;
    }
}
