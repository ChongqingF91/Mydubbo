package com.debug.liang.dubbo.two.server.request;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RecordPushRequest {

    //商品id
    private Integer itemId;

    //下单数量
    private Integer total;

    //客户姓名
    private String customerName;

}
