package com.mask.shardingspherejdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mask.shardingspherejdbc.bo.OrderInfo;
import com.mask.shardingspherejdbc.mapper.OrderInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

@SpringBootTest
class ShardingsphereJdbcApplicationTests {
    
    
    @Resource
    private OrderInfoMapper orderInfoMapper;
    
    Random random = new Random();
    
    @Test
    void addUser() {
        for (int i = 0; i < 10; i++) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(Long.valueOf(i));
            orderInfoMapper.insert(orderInfo);
        }
    }
    
    @Test
    void listOrderInfo() {
        QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();
        System.out.println(orderInfoMapper.selectList(wrapper));
    }
}
