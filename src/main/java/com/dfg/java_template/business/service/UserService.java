package com.dfg.java_template.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.framework.security.param.LoginBody;

/**
* @author zgc
* @since 2025-05-15 15:13:18
*/
public interface UserService extends IService<User> {

    /**
    * 保存用户信息
    *
    * @param userSaveParam 保存用户信息参数
    */
    void saveUser(UserSaveParam userSaveParam);

    /**
    * 修改用户信息
    *
    * @param userUpdateParam 修改用户信息参数
    */
    void updateUser(UserUpdateParam userUpdateParam);

    /**
    * 查询用户信息列表
    *
    * @param userListParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    PageVO<UserVO> listUser(UserListParam userListParam);

    /**
    * 查询用户信息详情
    *
    * @param userQueryParam 查询用户信息详情参数
    * @return 用户信息VO
    */
    UserVO queryUser(UserQueryParam userQueryParam);

    /**
    * 删除用户信息
    *
    * @param removeBaseParam 删除用户信息参数
    */
    void removeUser(RemoveBaseParam removeBaseParam);

    /**
     * 用户登录
     * @param loginBody 登录参数
     * @return token 令牌
     */
    String loginUser(LoginBody loginBody);
}
