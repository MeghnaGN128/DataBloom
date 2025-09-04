package com.xworkz.user.repository;

import com.xworkz.user.entity.RegisterEntity;
import com.xworkz.user.service.DBConnection;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Slf4j
public class RegisterRepositoryImpl implements RegisterRepository {

    @Autowired
    private DBConnection emf;

//    private Logger log = LoggerFactory.getLogger(RegisterRepositoryImpl.class);

    public RegisterRepositoryImpl() {
        log.info("RegisterRepositoryImpl instantiated...");
    }

    @Override
    public boolean save(RegisterEntity entity) {
        EntityManager em = null;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            log.info("Data stored: {}", entity);
            return true;
        } catch (PersistenceException e) {
            log.error("Error saving entity", e);
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) em.close();
        }
        return false;
    }

    @Override
    public RegisterEntity acceptLogin(String email) {
        EntityManager em = null;
        try {
            em = emf.entityManager();
            return em.createNamedQuery("acceptLogin", RegisterEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.warn("No user found for email: {}", email);
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public String getEmail(String email) {
        EntityManager em = null;
        try {
            em = emf.entityManager();
            return em.createNamedQuery("getEmail", String.class)
                    .setParameter("email", email)   // ✅ make sure matches NamedQuery parameter
                    .getSingleResult();
        } catch (NoResultException e) {
            log.warn("Email not found: {}", email);
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public Long getMobile(Long mobile) {
        EntityManager em = null;
        try {
            em = emf.entityManager();
            return em.createNamedQuery("getMobile", Long.class)
                    .setParameter("mobile", mobile)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.warn("Mobile not found: {}", mobile);
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public String getPassword(String email) {
        System.out.println("get password");
        EntityManager em=null;
        String entity=null;
        try{
            em=emf.entityManager();
            entity=(String) em.createNamedQuery("getPassword").setParameter("email",email).getSingleResult();
        }catch (PersistenceException e){
            e.printStackTrace();
            return null;
        }finally {
                if(em!=null&& em.isOpen()){
                    em.close();
            }
        }
        return entity;
    }

    @Override
    public boolean updatePassword(String email, String password) {
        System.out.println("update password");
        EntityManager em=null;
        int rows=0;
        try{
            em=emf.entityManager();
            em.getTransaction().begin();
            rows=em.createNamedQuery("updatePassword").setParameter("email",email).setParameter("password",password).executeUpdate();
            System.out.println(rows+"are updated");
            if(rows>0){
                em.getTransaction().commit();;
                return true;
            }
        }catch (PersistenceException e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }finally {
            if(em!=null&&em.isOpen()){
                em.close();
            }
        }
        return false;
    }

    @Override
    public boolean setPassword(String email, String password) {
        EntityManager em = null;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            int rows = em.createNamedQuery("updatePassword")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .executeUpdate();
            if (rows > 0) {
                em.getTransaction().commit();
                log.info("Password updated for email: {}", email);
                return true;
            } else {
                em.getTransaction().rollback();
            }
        } catch (PersistenceException e) {
            log.error("Error updating password", e);
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) em.close();
        }
        return false;
    }

    @Override
    public boolean setOtpByemail(String email, String otp) {
        System.out.println("GET OTP REPO");
        EntityManager em = null;
        int rows=0;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            rows = em.createNamedQuery("setOtpByMail").setParameter("otp",otp).setParameter("email",email).executeUpdate();
            System.out.println(rows+" are Updated");

            if (rows>0){
                em.getTransaction().commit();
                return true;
            }
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
         return false;
    }
}
