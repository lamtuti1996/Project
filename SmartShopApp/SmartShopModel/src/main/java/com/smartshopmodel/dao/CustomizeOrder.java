package com.smartshopmodel.dao;

import java.util.List;

import com.smartshopcommon.entity.OrderCustomize;

public interface CustomizeOrder {
    public List<OrderCustomize>   findAllOrderDetailByOrderID(String id,int firstResult, int maxResults);

    long getCountAllOrderDetailByOrderID(String id);
}
