package com.codegym.repository.impl;


import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {
    @Override
    public List<Comment> findAllByDate() {
        LocalDate localDate = LocalDate.now();
        TypedQuery<Comment> typedQuery= BaseRepository.entityManager.
                createQuery("select s"+" from comment s"+" where date=' "+localDate+"'",Comment.class);

        return typedQuery.getResultList();
    }

    @Override
    public Comment findById(int id) {
        TypedQuery<Comment>typedQuery=BaseRepository.entityManager.
                createQuery("select s"+" from comment s"+" where s.id=?1",Comment.class);
        typedQuery.setParameter(1,id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(comment.getId()==null){
            BaseRepository.entityManager.persist(comment);
        }
        else
        {
            BaseRepository.entityManager.merge(comment);
        }
        entityTransaction.commit();
    }


    @Override
    public void delete(Comment comment) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(comment);
        entityTransaction.commit();
    }
}
