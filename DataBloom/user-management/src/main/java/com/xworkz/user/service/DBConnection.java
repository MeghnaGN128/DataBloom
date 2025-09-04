package com.xworkz.user.service;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Component
public class DBConnection {
    private EntityManagerFactory emf;
    public EntityManager entityManager(){
        if(emf==null){
            try {

                    emf = Persistence.createEntityManagerFactory("x-workz");
                }catch (PersistenceException e) {
                e.printStackTrace();
            }
        }
        return emf.createEntityManager();
    }
    @PreDestroy
    public void close(){
        if(emf!=null&& emf.isOpen()){
            emf.close();
        }
    }
}
