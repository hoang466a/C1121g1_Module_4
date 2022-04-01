package com.huyhoang.service;

import java.util.HashMap;

public interface IServiceDictionary {
    public HashMap<String, String> list();
    public String translate(String english);
}
