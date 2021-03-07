package com.mask.shardingspherejdbc.bo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderInfo implements java.io.Serializable {
    private Long id;

    private String orderno;

    private Double totalAmount;

    private Double payAmount;

    private Boolean state;

    private Long payTime;

    private Long endTime;

    private Long createtime;

    private Long updatetime;
}