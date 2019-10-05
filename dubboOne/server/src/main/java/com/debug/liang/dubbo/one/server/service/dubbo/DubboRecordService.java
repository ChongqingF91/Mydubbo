package com.debug.liang.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.debug.liang.dubbo.one.api.enums.StatusCode;
import com.debug.liang.dubbo.one.api.request.PushOrderDto;
import com.debug.liang.dubbo.one.api.response.BaseResponse;
import com.debug.liang.dubbo.one.api.service.IDubboRecordService;
import com.debug.liang.dubbo.one.model.entity.ItemInfo;
import com.debug.liang.dubbo.one.model.entity.OrderRecord;
import com.debug.liang.dubbo.one.model.mapper.ItemInfoMapper;
import com.debug.liang.dubbo.one.model.mapper.OrderRecordMapper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;


//@Service 校验为validation = "ture"
@Service(protocol = {"dubbo","rest"},version = "1.0",timeout = 30000)
@Path("record")
public class DubboRecordService implements IDubboRecordService {
   private  static final Logger Log= LoggerFactory.getLogger(DubboRecordService.class);

   @Autowired
   private ItemInfoMapper itemInfoMapper;

   @Autowired
   private OrderRecordMapper orderRecordMapper;
    /**
     *下单服务
     * @param dto
     */
    @Override
    @Path("push")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON )
    @Produces(value = MediaType.APPLICATION_JSON )
    public BaseResponse pushOrder(PushOrderDto dto) {
        if (dto.getItemId()==null || dto.getItemId()<=0 || Strings.isNullOrEmpty(dto.getCustomerName())
            || dto.getTotal()==null){
             return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try{
            //TODO:实际的业务逻辑

           ItemInfo  info=itemInfoMapper.selectByPrimaryKey(dto.getItemId());

           //TODO：商品信息是否存在
           if (info==null){
               return new BaseResponse(StatusCode.ItemNotExist);

           }
           //TODO：库存服务-校验

            //TODO:客户中心服务-校验

            //TODO:订单服务
            OrderRecord entity= new OrderRecord();
            BeanUtils.copyProperties(dto,entity);
            entity.setOrderTime(new Date());
            orderRecordMapper.insertSelective(entity);

            response.setData(entity.getId());

        }catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }

        return  response;

}
}
