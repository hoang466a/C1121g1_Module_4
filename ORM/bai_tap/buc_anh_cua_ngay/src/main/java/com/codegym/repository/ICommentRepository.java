package com.codegym.repository;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAllByDate();

    Comment findById(int id);

    void save(Comment comment);

    void delete(Comment comment);
}
