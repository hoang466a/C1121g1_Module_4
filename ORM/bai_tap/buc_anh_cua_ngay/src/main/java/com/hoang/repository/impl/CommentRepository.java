package com.hoang.repository.impl;


import com.hoang.model.Comment;
import com.hoang.repository.ICommentRepository;
import com.hoang.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentRepository implements ICommentRepository {
    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public void edit(Comment comment) {

    }

    @Override
    public void delete(Comment comment) {

    }
}
