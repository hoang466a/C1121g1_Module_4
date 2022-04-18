package com.customer.vn.service;

import com.customer.vn.model.PassBook;
import com.customer.vn.model.Tenor;

import java.util.List;

public interface ITenorService  {
    List<Tenor> findAll();
}
