package com.codegym.service.impl;


import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;


    @Override
    public List<Comment> findAllByDate() {
        return iCommentRepository.findAllByDate();
    }

    @Override
    public Comment findById(int id) {
        return iCommentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        iCommentRepository.delete(comment);
    }
}
