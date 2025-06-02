package com.dfg.java_template.business.controller.front;

import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.business.service.UserService;
import com.dfg.java_template.framework.security.param.LoginBody;
import com.dfg.java_template.framework.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.auth.WxOpenAuthorizationInfo;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
* 用户信息 模块
* @author zgc
* @since 2025-05-15 15:13:18
*/
@Api(value = "用户信息模块", tags = "用户信息模块相关接口")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private WxOpenService wxOpenService;
    
    @PostMapping(value = "/front/saveUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增用户信息", produces = "application/json", consumes = "application/json")
    public R<?> saveUser(@Validated @RequestBody UserSaveParam userSaveParam){
        userService.saveUser(userSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/front/updateUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改用户信息", produces = "application/json", consumes = "application/json")
    public R<?> updateUser(@Validated @RequestBody UserUpdateParam userUpdateParam){
        userService.updateUser(userUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除用户信息", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/front/removeUser", produces = "application/json", consumes = "application/json")
    public R<?> removeUser(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        userService.removeUser(removeBaseParam);
        return R.ok();
    }
    
    @ApiOperation(value = "查询用户信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/front/listUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<UserVO>> listUser(@Validated @RequestBody UserListParam userListParam){
        return R.ok(userService.listUser(userListParam));
    }

    @ApiOperation(value = "查询用户信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/front/queryUser", produces = "application/json", consumes = "application/json")
    public R<UserVO> queryUser(@Validated @RequestBody UserQueryParam userQueryParam){
        return R.ok(userService.queryUser(userQueryParam));
    }

    @ApiOperation(value = "前台用户账号密码登录", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/loginUser", produces = "application/json", consumes = "application/json")
    public R<String> loginUser(@Validated @RequestBody LoginBody loginBody){
        return R.ok(userService.loginUser(loginBody));
    }
    
}
