package com.home.springboot.OMS.dao;

import com.home.springboot.OMS.entity.Oms_order;

import java.util.List;


public interface Oms_orderDAO {
    List<Oms_order> findAll();

    Oms_order findById(int theId);

    List<Oms_order> findByUserName(String user_name);

    void save(Oms_order theOms_order);

    void save(Oms_order oms_order, String user_name);
}
