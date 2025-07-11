package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysUserListParam;
import com.dfg.java_template.business.param.page.SysUserPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserSaveParam;
import com.dfg.java_template.business.param.update.SysUserUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserVO;
import com.dfg.java_template.business.service.SysUserService;
import com.dfg.java_template.framework.security.param.LoginBody;
import com.dfg.java_template.common.web.R;
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
 * 后台用户 模块
 *
 * @author zgc
 * @since 2025-06-30 11:42:56
 */
@Api(value = "后台用户模块", tags = "后台用户模块相关接口")
@RestController
@RequestMapping("/api/v1/sysUser/back")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping(value = "/saveSysUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增后台用户", produces = "application/json", consumes = "application/json")
    public R<?> saveSysUser(@Validated @RequestBody SysUserSaveParam sysUserSaveParam) {
        sysUserService.saveSysUser(sysUserSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateSysUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改后台用户", produces = "application/json", consumes = "application/json")
    public R<?> updateSysUser(@Validated @RequestBody SysUserUpdateParam sysUserUpdateParam) {
        sysUserService.updateSysUser(sysUserUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除后台用户", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeSysUser", produces = "application/json", consumes = "application/json")
    public R<?> removeSysUser(@Validated @RequestBody RemoveBaseParam removeBaseParam) {
        sysUserService.removeSysUser(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "前台用户查询后台用户列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontListSysUser", produces = "application/json", consumes = "application/json")
    public R<List<SysUserVO>> frontListSysUser(@Validated @RequestBody SysUserListParam sysUserListParam) {
        return R.ok(sysUserService.frontListSysUser(sysUserListParam));
    }

    @ApiOperation(value = "前台用户分页查询后台用户列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPageSysUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysUserVO>> frontPageSysUser(@Validated @RequestBody SysUserPageParam sysUserPageParam) {
        return R.ok(sysUserService.frontPageSysUser(sysUserPageParam));
    }

    @ApiOperation(value = "前台用户查询后台用户详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQuerySysUser", produces = "application/json", consumes = "application/json")
    public R<SysUserVO> frontQuerySysUser(@Validated @RequestBody SysUserQueryParam sysUserQueryParam) {
        return R.ok(sysUserService.frontQuerySysUser(sysUserQueryParam));
    }

    @ApiOperation(value = "后台用户查询后台用户列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backListSysUser", produces = "application/json", consumes = "application/json")
    public R<List<SysUserVO>> backListSysUser(@Validated @RequestBody SysUserListParam sysUserListParam) {
        return R.ok(sysUserService.backListSysUser(sysUserListParam));
    }

    @ApiOperation(value = "后台用户分页查询后台用户列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPageSysUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysUserVO>> backPageSysUser(@Validated @RequestBody SysUserPageParam sysUserPageParam) {
        return R.ok(sysUserService.backPageSysUser(sysUserPageParam));
    }

    @ApiOperation(value = "后台用户查询后台用户详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQuerySysUser", produces = "application/json", consumes = "application/json")
    public R<SysUserVO> backQuerySysUser(@Validated @RequestBody SysUserQueryParam sysUserQueryParam) {
        return R.ok(sysUserService.backQuerySysUser(sysUserQueryParam));
    }

    @ApiOperation(value = "后台用户账号密码登录", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/loginSysUser", produces = "application/json", consumes = "application/json")
    public R<String> loginSysUser(@Validated @RequestBody LoginBody loginBody) {
        return R.ok(sysUserService.loginSysUser(loginBody));
    }
}
