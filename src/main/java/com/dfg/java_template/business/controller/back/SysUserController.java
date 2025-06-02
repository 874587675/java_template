package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysUserListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserSaveParam;
import com.dfg.java_template.business.param.update.SysUserUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserVO;
import com.dfg.java_template.business.service.SysUserService;
import com.dfg.java_template.framework.security.param.LoginBody;
import com.dfg.java_template.framework.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
* 后台用户 模块
* @author zgc
* @since 2025-05-17 19:35:17
*/
@Api(value = "后台用户模块", tags = "后台用户模块相关接口")
@RestController
@RequestMapping("/api/v1")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PreAuthorize("hasAuthority('system:user:add')")
    @PostMapping(value = "/back/saveSysUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增后台用户", produces = "application/json", consumes = "application/json")
    public R<?> saveSysUser(@Validated @RequestBody SysUserSaveParam sysUserSaveParam){
        sysUserService.saveSysUser(sysUserSaveParam);
        return R.ok();
    }

    @PreAuthorize("hasAuthority('system:user:edit')")
    @PostMapping(value = "/back/updateSysUser", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改后台用户", produces = "application/json", consumes = "application/json")
    public R<?> updateSysUser(@Validated @RequestBody SysUserUpdateParam sysUserUpdateParam){
        sysUserService.updateSysUser(sysUserUpdateParam);
        return R.ok();
    }

    @PreAuthorize("hasAuthority('system:user:remove')")
    @ApiOperation(value = "根据主键删除后台用户", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/back/removeSysUser", produces = "application/json", consumes = "application/json")
    public R<?> removeSysUser(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        sysUserService.removeSysUser(removeBaseParam);
        return R.ok();
    }

    @PreAuthorize("hasAuthority('system:user:list')")
    @ApiOperation(value = "查询后台用户列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/back/listSysUser", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysUserVO>> listSysUser(@Validated @RequestBody SysUserListParam sysUserListParam){
        return R.ok(sysUserService.listSysUser(sysUserListParam));
    }

    @PreAuthorize("hasAuthority('system:user:query')")
    @ApiOperation(value = "查询后台用户详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/back/querySysUser", produces = "application/json", consumes = "application/json")
    public R<SysUserVO> querySysUser(@Validated @RequestBody SysUserQueryParam sysUserQueryParam){
        return R.ok(sysUserService.querySysUser(sysUserQueryParam));
    }

    @ApiOperation(value = "后台用户账号密码登录", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/loginSysUser", produces = "application/json", consumes = "application/json")
    public R<String> loginSysUser(@Validated @RequestBody LoginBody loginBody){
        return R.ok(sysUserService.loginSysUser(loginBody));
    }

}
