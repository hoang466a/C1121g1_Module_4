package com.codegym.model;


import javax.persistence.*;

@Entity(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;
    private String author;
    private String feedback;
    @Column(name="number_like")
    private Long numberLike;
    @Column(name="date", columnDefinition = "date")
    private String date;

    public Comment() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(Long numberLike) {
        this.numberLike = numberLike;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
