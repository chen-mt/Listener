package com.loiterer.listener.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用于处理插入的时候某些属性值怎么改变的类
 * @author XieZhiJie
 * @date 2020/11/05 23:26
 */
@Component
public class ServiceMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 当插入信息的时候, 插入当前日期
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        // 当插入信息的时候, 也插入当前日期
        this.setFieldValByName("gmtModified", new Date(), metaObject);
        // 当插入的时候, 设置信件未读
        this.setFieldValByName("isRead", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新的时候修改为当前时间
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

}
