package com.codegym.model;

public class Mail {
    private String language;
    private Integer pageSize;
    private String spamFilter;
    private String signature;

    public Mail(String language, Integer pageSize, String spamfilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamfilter;
        this.signature = signature;
    }

    public Mail() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(String spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
