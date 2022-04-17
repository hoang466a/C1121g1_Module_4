package com.codegym.blog.dto;

import com.codegym.blog.model.Category;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class BlogDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idBlog;
    private String nameBlog;
    private String noteBlog;
    private String dateBlog;
    private Category categoryOb;

    public BlogDTO() {
    }



    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getNoteBlog() {
        return noteBlog;
    }

    public void setNoteBlog(String noteBlog) {
        this.noteBlog = noteBlog;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public Category getCategoryOb() {
        return categoryOb;
    }

    public void setCategoryOb(Category categoryOb) {
        this.categoryOb = categoryOb;
    }
}
