package com.xworkz.army.repository;

import com.xworkz.army.entity.ArmyEntity;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class ArmyRepositoryImpl implements  ArmyRepository {


    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");


    public ArmyRepositoryImpl(){
        System.out.println("Running in ArmyRepositoryImpl");
    }

    @Override
    public boolean save(ArmyEntity armyEntity) {
        System.out.println("save running in ArmyRepositoryImpl"+armyEntity);
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(armyEntity);
        et.commit();

//        EntityManager entityManager=null;
//        try {
//            entityManager=emf.createEntityManager();
//        }catch (PersistenceException e)
//        {
//            System.out.println(e.getMessage());
//        }finally {
//            if(entityManager!=null)
//            {
//                entityManager.close();
//            }
//        }
        return true;
    }

    @Override
    public List<ArmyEntity> fetchAll() {
        System.out.println("method");
        EntityManager entityManager=null;
        List<ArmyEntity> list=null;
        try {
            list = emf.createEntityManager().createNamedQuery("fetchAll").getResultList();
        } catch (PersistenceException e) {
            list = Collections.emptyList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return list;

    }

    @Override
    public ArmyEntity featchById(Integer id) {
        EntityManager em=null;
        ArmyEntity army=null;
        try{
            em=emf.createEntityManager();
            army=(ArmyEntity) em.createNamedQuery("featchBYId").setParameter("id",id).getSingleResult();
            System.out.println("entity: "+army);
        }catch (PersistenceException e){
            e.printStackTrace();
        }  finally {
            if (em != null) {
                em.close();
            }
        }
        return army;
    }

    @Override
    public boolean updateArmyEntityById(ArmyEntity armyEntity) {
        EntityManager em=null;
        boolean isUpdate=false;
try{
    em=emf.createEntityManager();
    em.getTransaction().begin();
    int check=em.createNamedQuery("updateArmyEntityById")
            .setParameter("armyName",armyEntity.getArmyName())
            .setParameter("country",armyEntity.getCountry())
            .setParameter("commanderName",armyEntity.getCommanderName())
            .setParameter("baseLocation",armyEntity.getBaseLocation())
            .setParameter("establishedDate",armyEntity.getEstablishedDate())
            .setParameter("armyId",armyEntity.getArmyId())
            .executeUpdate();
    if(check>0){
        em.getTransaction().commit();
        isUpdate=true;
    }
}catch (NoResultException| QueryException e){
    System.out.println(e.getMessage());
    em.getTransaction().rollback();
}finally {
    if(em!=null&& em.isOpen()){
        em.close();
    }
}
        return isUpdate;
    }

    @Override
    public boolean deleteById(Integer id) {
        EntityManager em=null;
        boolean isDelete=false;
        try{
            em=emf.createEntityManager();
            em.getTransaction().begin();
            int check=em.createNamedQuery("deleteById")
                    .setParameter("armyId",id)
                    .executeUpdate();
            System.out.println("udated rows"+check);
            if(check>0){
                em.getTransaction().commit();
                isDelete=true;
            }
        }catch (NoResultException| QueryException e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally {
            if(em!=null&& em.isOpen()){
                em.close();
            }
        }
        return isDelete;
    }
}
