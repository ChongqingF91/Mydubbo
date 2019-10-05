package com.debug.liang.dubbo.one.api.service;

import com.debug.liang.dubbo.one.api.response.BaseResponse;


/**
 * @Liang vapy  2019/9/20
 **/
public interface IDubboItemService {

    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo,Integer PageSize );

    BaseResponse listPageItemsParams (Integer pageNo, Integer PageSize, String search);

}
