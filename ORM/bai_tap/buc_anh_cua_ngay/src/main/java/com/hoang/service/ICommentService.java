package com.hoang.service;

import com.hoang.model.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> findAll();

    void save(Comment comment);

    void edit(Comment comment);

    void delete(Comment comment);

}
