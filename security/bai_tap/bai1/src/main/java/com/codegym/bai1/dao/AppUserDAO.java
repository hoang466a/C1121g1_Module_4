package com.codegym.bai1.dao;

import com.codegym.bai1.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class AppUserDAO {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName){
        try{
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser) query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
