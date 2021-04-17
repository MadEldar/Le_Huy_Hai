package com.Le_Huy_Hai.Dao;

import com.Le_Huy_Hai.Entity.PhoneEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PhoneDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertPhone(PhoneEntity phone){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(phone);
        em.getTransaction().commit();
        em.close();
    }

    public void updatePhone(int id, PhoneEntity updatingPhone){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneEntity phoneUpdate = em.find(PhoneEntity.class, id);
        if(phoneUpdate != null){
            phoneUpdate.setName(updatingPhone.getName());
            phoneUpdate.setBrand(updatingPhone.getBrand());
            phoneUpdate.setPrice(updatingPhone.getPrice());
            phoneUpdate.setDescription(updatingPhone.getDescription());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deletePhone(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneEntity phoneDelete = em.find(PhoneEntity.class, id);
        if (phoneDelete != null){
            em.remove(phoneDelete);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<PhoneEntity> getPhones(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<PhoneEntity> list = em.createQuery("select p from PhoneEntity p", PhoneEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public PhoneEntity getPhoneById(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneEntity phoneEntity = em.createQuery("select p from PhoneEntity p where p.id = " + id, PhoneEntity.class).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return phoneEntity;
    }
}
