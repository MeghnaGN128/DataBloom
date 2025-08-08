package com.xworkz.earbuds.repository;

import com.xworkz.earbuds.entity.EarbudsEntity;
import com.xworkz.earbuds.service.EarbudsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class EarbudsRepositoryImpl implements EarbudsRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

    public EarbudsRepositoryImpl() {
        System.out.println("Running in EarbudsRepositoryImpl");
    }

    @Override
    public boolean save(EarbudsEntity earbudsEntity) {
        System.out.println("save running in EarbudsRepositoryImpl"+earbudsEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(earbudsEntity);
        entityTransaction.commit();
        return false;
    }
}
