package com.xworkz.tourism.repository;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.service.TourismService;
import com.xworkz.tourism.service.TourismServiceImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class TourismRepositoryImpl implements TourismRepository{

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean saveTourism(TourismEntity entity) {
        System.out.println("running saveTourism in TourismRepoImpl" );

        if(entity!=null){
            EntityManager em=null;
            EntityTransaction et=null;

            System.out.println("Repo: "+entity);
            try{
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(entity);
                et.commit();


                System.out.println("saved successfully...");

            }
            catch (PersistenceException e){
                System.out.println(e.getMessage());
            }
            finally {
                if(em!=null){
                    em.close();
                }
            }

            return  true;
        }
        return false;
    }

    @Override
    public List<TourismEntity> fetchAll() {
        System.out.println("running fetchAll");
        List<TourismEntity> list=null;

        EntityManager em=null;

        try{
            em= emf.createEntityManager();
            list=em.createNamedQuery("fetchAll").getResultList();

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return list;
    }

    @Override
    public TourismEntity findByID(Integer id) {
        EntityManager em=null;
        TourismEntity entity=null;
        try{
            em=emf.createEntityManager();
            entity= em.find(TourismEntity.class,id);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if(em!=null){
                em.close();
            }
        }

        return entity;
    }

    @Override
    public boolean updateTourism(TourismEntity entity) {
        boolean isUpdated=false;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            em.getTransaction().begin();
            int rowsAffected=em.createNamedQuery("updateTourism").setParameter("destination",entity.getDestination())
                    .setParameter("startPoint",entity.getStartPoint())
                    .setParameter("packagePrice",entity.getPackagePrice())
                    .setParameter("vehicle",entity.getVehicle())
                    .setParameter("vehicleNumber",entity.getVehicleNumber())
                    .setParameter("noOfPeople",entity.getNoOfPeople())
                    .setParameter("startDate",entity.getStartDate())
                    .setParameter("endDate",entity.getEndDate())
                    .setParameter("tourID",entity.getTourID()).executeUpdate();
            System.out.println("rowsAffected: "+rowsAffected);
            if(rowsAffected>0){
                isUpdated=true;
            }
            em.getTransaction().commit();
        }catch(PersistenceException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return isUpdated;
    }

    @Override
    public boolean deleteById(Integer id) {
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            em.getTransaction().begin();
            int rows=em.createNamedQuery("deleteById").setParameter("tourID",id).executeUpdate();
            if(rows>0){
                System.out.println("data deleted in repo");
                em.getTransaction().commit();
                return true;

            }

        }
        catch(PersistenceException e ){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}