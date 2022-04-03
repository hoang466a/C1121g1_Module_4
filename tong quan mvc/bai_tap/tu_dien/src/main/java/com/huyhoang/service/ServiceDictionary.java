package com.huyhoang.service;

import com.huyhoang.repository.IRepositoryDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class ServiceDictionary implements IServiceDictionary {
    @Autowired
    IRepositoryDictionary iRepositoryDictionary;


    @Override
    public String translate(String english) {
        String vietnamese=null;
        HashMap<String, String> map= iRepositoryDictionary.list();
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
