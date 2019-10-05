package com.debug.liang.dubbo.one.server.controller;

import com.debug.liang.dubbo.one.api.enums.StatusCode;
import com.debug.liang.dubbo.one.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，
// 并且跳转到相应页面.若返回json等内容到页面，则需要加@ResponseBody注解
//@RestController为包含上述2种方法

@RestController
public class BaseController {

    private static final Logger Log =  LoggerFactory.getLogger(BaseController.class);
    private static final String prefix="base";

    /**
     * 测试
     * @param param
     * @return
     */
    @RequestMapping(value = prefix+"/one",method = RequestMethod.GET)

    public BaseResponse one(@RequestParam String param){
    BaseResponse response=new BaseResponse(StatusCode.Success);
    try {
         response.setData(param);
    }catch (Exception e){
        e.printStackTrace();
        response=new BaseResponse(StatusCode.Fail);
    }

    return response;
    }


}
