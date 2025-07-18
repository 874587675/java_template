package com.dfg.java_template.framework.generate.handle;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.dfg.java_template.framework.security.core.AuthenticationContextHolder;
import com.dfg.java_template.framework.security.util.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis-plus自动填充处理器
 *
 * @author zgc
 */

@Component
public class FillMetaObjectHandler implements MetaObjectHandler {

    @Value(value = "${mybatis-plus.global-config.db-config.logic-delete-value}")
    private Integer logicDeleteValue; // 逻辑删除值

    @Value(value = "${mybatis-plus.global-config.db-config.logic-not-delete-value}")
    private Integer logicNotDeleteValue; // 逻辑未删除值


    @Override
    public void insertFill(MetaObject metaObject) {
        Authentication backContext = AuthenticationContextHolder.getBackContext();
        if (ObjectUtil.isNotEmpty(backContext)) {
            this.strictInsertFill(metaObject, "createUserId", String.class, SecurityUtils.getUserId());
            this.strictInsertFill(metaObject, "updateUserId", String.class, SecurityUtils.getUserId());

        }
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());

        this.strictInsertFill(metaObject, "isDeleted", Integer.class, logicNotDeleteValue);
        this.strictInsertFill(metaObject, "version", Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Authentication backContext = AuthenticationContextHolder.getBackContext();
        if (ObjectUtil.isNotEmpty(backContext)) {
            this.strictUpdateFill(metaObject, "updateUserId", String.class, SecurityUtils.getUserId());
        }
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        Object deletedVal = getFieldValByName("isDeleted", metaObject);
        if (deletedVal != null && deletedVal.equals(logicDeleteValue)) {
            this.strictUpdateFill(metaObject, "deleteTime", Date.class, new Date());
        }
    }
}
