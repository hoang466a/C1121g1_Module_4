package com.huyhoang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class ServiceDictionary implements IServiceDictionary {
    @Autowired
    IServiceDictionary iServiceDictionary;

    @Override
    public HashMap<String, String> list() {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("cat","con mèo");
        hashMap.put("book","sách");
        hashMap.put("dog","chó");
        return hashMap;
    }

    @Override
    public String translate(String english) {
        String vietnamese=null;
        HashMap<String, String> map= iServiceDictionary.list();
        for(String word:map.keySet())
        {
            if((word.toLowerCase()).equals(english.toLowerCase()))
            {
                vietnamese=map.get(word);
                break;
            }
            else{
                vietnamese="don't have result";
            }
        }
        return vietnamese;
    }
}
