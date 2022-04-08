package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> findAllByDate();

    Comment findById(int id);

    void save(Comment comment);

    void delete(Comment comment);

}
