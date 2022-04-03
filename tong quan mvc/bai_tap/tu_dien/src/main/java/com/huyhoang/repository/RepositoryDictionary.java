package com.huyhoang.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class RepositoryDictionary implements IRepositoryDictionary {
    @Override
    public HashMap<String, String> list() {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("cat","con mèo");
        hashMap.put("book","sách");
        hashMap.put("dog","chó");
        return hashMap;
    }
}
