package com.dfg.java_template.business.controller.front;

import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.page.UserPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.business.service.UserService;
import com.dfg.java_template.framework.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
* 用户信息 模块
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Api(value = "用户信息模块", tags = "用户信息模块相关接口")
@RestController
@RequestMapping("/api/v1/user/frontW")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/saveUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增用户信息", produces = "application/json", consumes = "application/json")
    public R<?> saveUser(@Validated @RequestBody UserSaveParam userSaveParam){
        userService.saveUser(userSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改用户信息", produces = "application/json", consumes = "application/json")
    public R<?> updateUser(@Validated @RequestBody UserUpdateParam userUpdateParam){
        userService.updateUser(userUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除用户信息", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeUser", produces = "application/json", consumes = "application/json")
    public R<?> removeUser(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        userService.removeUser(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "前台用户查询用户信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontListUser", produces = "application/json", consumes = "application/json")
    public R<List<UserVO>> frontListUser(@Validated @RequestBody UserListParam userListParam){
        return R.ok(userService.frontListUser(userListParam));
    }

    @ApiOperation(value = "前台用户分页查询用户信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPageUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<UserVO>> frontPageUser(@Validated @RequestBody UserPageParam userPageParam){
        return R.ok(userService.frontPageUser(userPageParam));
    }

    @ApiOperation(value = "前台用户查询用户信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQueryUser", produces = "application/json", consumes = "application/json")
    public R<UserVO> frontQueryUser(@Validated @RequestBody UserQueryParam userQueryParam){
        return R.ok(userService.frontQueryUser(userQueryParam));
    }

    @ApiOperation(value = "后台用户查询用户信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backListUser", produces = "application/json", consumes = "application/json")
    public R<List<UserVO>> backListUser(@Validated @RequestBody UserListParam userListParam){
        return R.ok(userService.backListUser(userListParam));
        }

    @ApiOperation(value = "后台用户分页查询用户信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPageUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<UserVO>> backPageUser(@Validated @RequestBody UserPageParam userPageParam){
        return R.ok(userService.backPageUser(userPageParam));
        }
    
    @ApiOperation(value = "后台用户查询用户信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQueryUser", produces = "application/json", consumes = "application/json")
    public R<UserVO> backQueryUser(@Validated @RequestBody UserQueryParam userQueryParam){
        return R.ok(userService.backQueryUser(userQueryParam));
        }            

}
