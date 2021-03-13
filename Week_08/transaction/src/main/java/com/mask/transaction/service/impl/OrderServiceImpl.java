package com.mask.transaction.service.impl;

import com.mask.transaction.bo.Order;
import com.mask.transaction.mapper.OrderMapper;
import com.mask.transaction.service.OrderService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    
    @Override
    public void insertOrder(Order tOrder) {
        orderMapper.insert(tOrder);
    }
    
    @Override
    public void updateOrder(Order tOrder) {
        orderMapper.updateByPrimaryKey(tOrder);
    }
    
    @Override
    public void deleteOrder(Order tOrder) {
        orderMapper.deleteByPrimaryKey(tOrder);
    }
    @Override
    public void selectOrder(Order tOrder) {
        orderMapper.updateByPrimaryKeySelective(tOrder);
    }
    
    @Override
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void insertOrderTransaction(Order tOrder){
        orderMapper.insert(tOrder);
        System.out.println(1/0);
    }
}
