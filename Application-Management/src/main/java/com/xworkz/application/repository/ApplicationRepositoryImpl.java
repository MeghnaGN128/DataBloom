package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
    EntityManager entityManager = null;

    @Autowired
    ApplicationService applicationService;

    ApplicationEntity applicationEntity;

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(applicationEntity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.find(ApplicationEntity.class, id);
            System.out.println(applicationEntity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity entity, Integer id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            ApplicationEntity found = entityManager.find(ApplicationEntity.class, id);
            if (found != null) {
                found.setApplicationName(entity.getApplicationName());
                found.setApplicationSize(entity.getApplicationSize());
                found.setCompany(entity.getCompany());
                found.setNoOfUsers(entity.getNoOfUsers());
                found.setRatings(entity.getRatings());
                found.setLaunchDate(entity.getLaunchDate());
                entityManager.merge(found);
            }
            entityManager.getTransaction().commit();
            return found;
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return null;
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            ApplicationEntity found = entityManager.find(ApplicationEntity.class, id);
            if (found != null) {
                entityManager.remove(found);
            }
            entityManager.getTransaction().commit();
            return found;
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return null;
    }

    @Override
    public ApplicationEntity findApplicationByName(String name) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findByName", ApplicationEntity.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("findByName: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for name: " + name);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findBySize(String size) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findBySize", ApplicationEntity.class)
                    .setParameter("size", size)
                    .getSingleResult();
            System.out.println("findBySize: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for size: " + size);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByCompany(String company) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findByCompany", ApplicationEntity.class)
                    .setParameter("company", company)
                    .getSingleResult();
            System.out.println("findByCompany: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for company: " + company);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByUsers(Integer users) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findByUsers", ApplicationEntity.class)
                    .setParameter("users", users)
                    .getSingleResult();
            System.out.println("findByUsers: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for users: " + users);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByRatings(Float ratings) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findByRatings", ApplicationEntity.class)
                    .setParameter("ratings", ratings)
                    .getSingleResult();
            System.out.println("findByRatings: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for ratings: " + ratings);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }

    @Override
    public ApplicationEntity findByDate(LocalDate date) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            applicationEntity = entityManager.createNamedQuery("findByDate", ApplicationEntity.class)
                    .setParameter("date", date)
                    .getSingleResult();
            System.out.println("findByDate: " + applicationEntity);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No result found for date: " + date);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return applicationEntity;
    }
}
