package com.hoang.repository.impl;


import com.hoang.model.Comment;
import com.hoang.repository.ICommentRepository;
import com.hoang.repository.impl.BaseRepository;
import com.hoang.service.ICommentService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {
    @Override
    public List<Comment> findAllByDate() {
        TypedQuery<Comment> typedQuery= BaseRepository.
                entityManager.
                createQuery("select s"+" from comment s"+" where date='2022/5/4'",Comment.class);

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
