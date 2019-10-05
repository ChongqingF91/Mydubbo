package com.debug.liang.dubbo.two.server.data;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Liang vapy  2019/10/6
 **/
@Data
@ToString
public class DubboRecordResponse implements Serializable {

    private Integer code;

    private String msg;

    private Integer data;
}
