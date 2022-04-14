package com.codegym.blog.model;


import javax.persistence.*;


@Entity(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idBlog;
    private String nameBlog;
    private String noteBlog;
    @Column(columnDefinition = "date")
    private String dateBlog;

    @ManyToOne
    @JoinColumn(name="id_category",referencedColumnName = "idCategory")
    private Category categoryOb;

    public Blog() {
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
