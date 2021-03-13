package com.mask.transaction.service;

import com.mask.transaction.bo.Order;

public interface OrderService {
    void insertOrder(Order tOrder);
    
    void updateOrder(Order tOrder);
    
    void deleteOrder(Order tOrder);
    
    void selectOrder(Order tOrder);
}
