package com.dfg.java_template.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.entity.SysUser;
import com.dfg.java_template.business.param.list.SysUserListParam;
import com.dfg.java_template.business.param.page.SysUserPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserSaveParam;
import com.dfg.java_template.business.param.update.SysUserUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserVO;
import com.dfg.java_template.framework.security.param.LoginBody;

import java.util.List;
/**
* @author zgc
* @since 2025-07-01 15:33:56
*/
public interface SysUserService extends IService<SysUser> {

    /**
    * 保存后台用户
    *
    * @param sysUserSaveParam 保存后台用户参数
    */
    void saveSysUser(SysUserSaveParam sysUserSaveParam);

    /**
    * 修改后台用户
    *
    * @param sysUserUpdateParam 修改后台用户参数
    */
    void updateSysUser(SysUserUpdateParam sysUserUpdateParam);

    /**
    * 删除后台用户
    *
    * @param removeBaseParam 删除后台用户参数
    */
    void removeSysUser(RemoveBaseParam removeBaseParam);

    /**
    * 前台用户查询后台用户列表
    *
    * @param sysUserListParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    List<SysUserVO> frontListSysUser(SysUserListParam sysUserListParam);
    
    /**
    * 前台用户分页查询后台用户列表
    *
    * @param sysUserPageParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    PageVO<SysUserVO> frontPageSysUser(SysUserPageParam sysUserPageParam);

    /**
    * 前台用户查询后台用户详情
    *
    * @param sysUserQueryParam 查询后台用户详情参数
    * @return 后台用户VO
    */
    SysUserVO frontQuerySysUser(SysUserQueryParam sysUserQueryParam);
        
    /**
    * 后台用户查询后台用户列表
    *
    * @param sysUserListParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    List<SysUserVO> backListSysUser(SysUserListParam sysUserListParam);

    /**
    * 后台用户分页查询后台用户列表
    *
    * @param sysUserPageParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    PageVO<SysUserVO> backPageSysUser(SysUserPageParam sysUserPageParam);

    /**
    * 后台用户查询后台用户详情
    *
    * @param sysUserQueryParam 查询后台用户详情参数
    * @return 后台用户VO
    */
    SysUserVO backQuerySysUser(SysUserQueryParam sysUserQueryParam);
    /**
     * 后台用户登录
     * @param loginBody 登录用户信息
     * @return 登录成功的token
     */
    String loginSysUser(LoginBody loginBody);
}
