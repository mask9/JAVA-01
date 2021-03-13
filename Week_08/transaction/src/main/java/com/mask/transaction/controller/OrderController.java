package com.mask.transaction.controller;

import com.mask.transaction.bo.Order;
import com.mask.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/insert")
    public void insert(Long id,Long userId) {
        Order tOrder = new Order();
        tOrder.setId(id);
        tOrder.setUserId(userId);
        orderService.insertOrder(tOrder);
    }
    
    @RequestMapping("/updata")
    public void updata(Long id,Long userId) {
        Order tOrder = new Order();
        tOrder.setId(id);
        tOrder.setUserId(userId);
        orderService.updateOrder(tOrder);
    }
    
    @RequestMapping("/delete")
    public void delete(Long id,Long userId) {
        Order tOrder = new Order();
        tOrder.setId(id);
        tOrder.setUserId(userId);
        orderService.deleteOrder(tOrder);
    }
    
    @RequestMapping("/select")
    public void select(Long id,Long userId) {
        Order tOrder = new Order();
        tOrder.setId(id);
        tOrder.setUserId(userId);
        orderService.selectOrder(tOrder);
    }
}
