package com.codegym.blog.dto;

import com.codegym.blog.model.Blog;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

public class CategoryDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String nameCategory;
    Set<Blog> blogList;

    public CategoryDTO() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(Set<Blog> blogList) {
        this.blogList = blogList;
    }
}
