package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.UserPageParam;
import com.dfg.java_template.business.param.vo.UserVO;
import java.util.List;
/**
* @author zgc
* @since 2025-06-30 11:42:56
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
    * 删除用户信息
    *
    * @param removeBaseParam 删除用户信息参数
    */
    void removeUser(RemoveBaseParam removeBaseParam);

    /**
    * 前台用户查询用户信息列表
    *
    * @param userListParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    List<UserVO> frontListUser(UserListParam userListParam);
    
    /**
    * 前台用户分页查询用户信息列表
    *
    * @param userPageParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    PageVO<UserVO> frontPageUser(UserPageParam userPageParam);

    /**
    * 前台用户查询用户信息详情
    *
    * @param userQueryParam 查询用户信息详情参数
    * @return 用户信息VO
    */
    UserVO frontQueryUser(UserQueryParam userQueryParam);
        
    /**
    * 后台用户查询用户信息列表
    *
    * @param userListParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    List<UserVO> backListUser(UserListParam userListParam);

    /**
    * 后台用户分页查询用户信息列表
    *
    * @param userPageParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    PageVO<UserVO> backPageUser(UserPageParam userPageParam);

    /**
    * 后台用户查询用户信息详情
    *
    * @param userQueryParam 查询用户信息详情参数
    * @return 用户信息VO
    */
    UserVO backQueryUser(UserQueryParam userQueryParam);        
}
