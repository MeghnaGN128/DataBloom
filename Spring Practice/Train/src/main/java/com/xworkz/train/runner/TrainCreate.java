package com.xworkz.train.runner;

import com.xworkz.train.entity.TrainEntity;

import javax.persistence.*;

public class TrainCreate {
    public static void main(String[] args) {
        TrainEntity trainEntity = new TrainEntity();
        trainEntity.setTrainName("Chennai Express");
        trainEntity.setSource("Chellakere");
        trainEntity.setDestination("Chennai");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//Load,Register,connection driver
            entityManager = entityManagerFactory.createEntityManager();//DMl(Upadte,Delete,Insert),DQL(Select)
            entityTransaction = entityManager.getTransaction();//TCL(Transaction Control Language(commit,rollback,savepoint,autocommit)

            entityTransaction.begin();//auto commit=0 (temp)
            entityManager.persist(trainEntity);
            System.out.println(trainEntity);
            System.out.println("connected");
            entityTransaction.commit();//auto commit=1 (permanent)
            System.out.println("Inserted Data");

        } catch (PersistenceException e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            if (entityManagerFactory != null) {
                System.out.println("entityManagerFactory");
                entityManagerFactory.close();
            }
            if (entityManager!=null){
                System.out.println("entityManager");
                entityManager.close();
            }
        }

    }
}
