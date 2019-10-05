package com.debug.liang.dubbo.one.server.service.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.debug.liang.dubbo.one.api.enums.StatusCode;
import com.debug.liang.dubbo.one.api.response.BaseResponse;
import com.debug.liang.dubbo.one.api.service.IDubboItemService;
import com.debug.liang.dubbo.one.model.entity.ItemInfo;
import com.debug.liang.dubbo.one.model.mapper.ItemInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @Liang vapy  2019/8/2
 **/
@Service(protocol = {"dubbo","rest"},version = "1.0",timeout = 3000)
@Path("liangOne")
public class DubboItemService implements IDubboItemService {

    private static final Logger Log = LoggerFactory.getLogger(DubboItemService.class);

    //@Resource是Java自己的注解，可以通过指定bean，来区分不同的时间类
    @Autowired
    private ItemInfoMapper itemInfoMapper;

    /**
     * 列表查询服务，实际业务逻辑
     *
     * @return
     */

    @Path("item/list")
    public BaseResponse listItems() {
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            List<ItemInfo> infos=itemInfoMapper.selectAll();
            Log.info("查询到的商品列表数据：{} ",infos);
            response.setData(infos);

        }catch (Exception e){
            Log.error("列表分页查询服务-实际的业务逻辑异常：",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
        }




    /**
     * 列表查询分页查询
     * @return
     */
    @Path("item/page/list")
    public  BaseResponse listPageItems(@QueryParam("pageNo") Integer pageNo,
                                       @QueryParam("PageSize") Integer PageSize)
    {
        BaseResponse response= new BaseResponse(StatusCode.Success);

        try{
            //TODO:分页组件-第pageNo页，pageSize条数目数据
            PageHelper.startPage(pageNo,PageSize);
            PageInfo info=new PageInfo<ItemInfo>(itemInfoMapper.selectAll());
            response.setData(info);

        }catch (Exception e){
            Log.error("列表分页查询服务-实际的业务逻辑异常：",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * 列表模糊字段查询
     * @return
     */
    @Path("item/page/list")
    public  BaseResponse listPageItemsParams(@QueryParam("pageNo") Integer pageNo,
                                       @QueryParam("PageSize") Integer PageSize,
                                       @QueryParam("search") String search) {
        BaseResponse response= new BaseResponse(StatusCode.Success);

        try{
            //TODO:分页组件-第pageNo页，pageSize条数目数据
            PageHelper.startPage(pageNo,PageSize);
            PageInfo info=new PageInfo<ItemInfo>(itemInfoMapper.selectAllByParams(search));
            response.setData(info);

        }catch (Exception e){
            Log.error("列表分页查询服务-实际的业务逻辑异常：",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

}
