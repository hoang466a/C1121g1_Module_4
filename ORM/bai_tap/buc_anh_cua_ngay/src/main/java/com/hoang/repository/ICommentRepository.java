package com.hoang.repository;

import com.hoang.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();

    void save(Comment comment);

    void edit(Comment comment);

    void delete(Comment comment);
}
