package com.hoang.repository.impl;

import com.hoang.model.Customer;
import com.hoang.repository.ICustomerRepository;
import com.hoang.service.ICustomerService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery=
                BaseRepository.entityManager.createQuery(
                        "select s"+" from customer s",Customer.class
                );

        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> typedQuery=BaseRepository.entityManager.createQuery("select s"+
                " from customer s"+" where s.id=?1",Customer.class
        );
        typedQuery.setParameter(1,id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(customer.getId()==null){
            BaseRepository.entityManager.persist(customer);
        }
        else{
            BaseRepository.entityManager.merge(customer);
        }
        entityTransaction.commit();
    }


    @Override
    public void delete(Long id) {
        TypedQuery<Customer> typedQuery=BaseRepository.entityManager.createQuery("delete s"+
                " from customer s"+" where s.id=?1",Customer.class
        );
        typedQuery.setParameter(1,id);
    }

    @Override
    public void delete(Customer customer) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(customer.getId()==null){

        }
        else{
            BaseRepository.entityManager.remove(customer);
        }
    }
}
