package com.debug.liang.dubbo.one.api.service;

import com.debug.liang.dubbo.one.api.request.PushOrderDto;
import com.debug.liang.dubbo.one.api.response.BaseResponse;


public interface IDubboRecordService {

     BaseResponse pushOrder(PushOrderDto dto);
}
