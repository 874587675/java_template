package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysUserRoleListParam;
import com.dfg.java_template.business.param.page.SysUserRolePageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserRoleSaveParam;
import com.dfg.java_template.business.param.update.SysUserRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserRoleVO;
import com.dfg.java_template.business.service.SysUserRoleService;
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
* 用户角色关联 模块
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Api(value = "用户角色关联模块", tags = "用户角色关联模块相关接口")
@RestController
@RequestMapping("/api/v1/sysUserRole/back")
public class SysUserRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping(value = "/saveSysUserRole", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增用户角色关联", produces = "application/json", consumes = "application/json")
    public R<?> saveSysUserRole(@Validated @RequestBody SysUserRoleSaveParam sysUserRoleSaveParam){
        sysUserRoleService.saveSysUserRole(sysUserRoleSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateSysUserRole", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改用户角色关联", produces = "application/json", consumes = "application/json")
    public R<?> updateSysUserRole(@Validated @RequestBody SysUserRoleUpdateParam sysUserRoleUpdateParam){
        sysUserRoleService.updateSysUserRole(sysUserRoleUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除用户角色关联", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeSysUserRole", produces = "application/json", consumes = "application/json")
    public R<?> removeSysUserRole(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        sysUserRoleService.removeSysUserRole(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "前台用户查询用户角色关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontListSysUserRole", produces = "application/json", consumes = "application/json")
    public R<List<SysUserRoleVO>> frontListSysUserRole(@Validated @RequestBody SysUserRoleListParam sysUserRoleListParam){
        return R.ok(sysUserRoleService.frontListSysUserRole(sysUserRoleListParam));
    }

    @ApiOperation(value = "前台用户分页查询用户角色关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPageSysUserRole", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysUserRoleVO>> frontPageSysUserRole(@Validated @RequestBody SysUserRolePageParam sysUserRolePageParam){
        return R.ok(sysUserRoleService.frontPageSysUserRole(sysUserRolePageParam));
    }

    @ApiOperation(value = "前台用户查询用户角色关联详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQuerySysUserRole", produces = "application/json", consumes = "application/json")
    public R<SysUserRoleVO> frontQuerySysUserRole(@Validated @RequestBody SysUserRoleQueryParam sysUserRoleQueryParam){
        return R.ok(sysUserRoleService.frontQuerySysUserRole(sysUserRoleQueryParam));
    }

    @ApiOperation(value = "后台用户查询用户角色关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backListSysUserRole", produces = "application/json", consumes = "application/json")
    public R<List<SysUserRoleVO>> backListSysUserRole(@Validated @RequestBody SysUserRoleListParam sysUserRoleListParam){
        return R.ok(sysUserRoleService.backListSysUserRole(sysUserRoleListParam));
        }

    @ApiOperation(value = "后台用户分页查询用户角色关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPageSysUserRole", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysUserRoleVO>> backPageSysUserRole(@Validated @RequestBody SysUserRolePageParam sysUserRolePageParam){
        return R.ok(sysUserRoleService.backPageSysUserRole(sysUserRolePageParam));
        }
    
    @ApiOperation(value = "后台用户查询用户角色关联详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQuerySysUserRole", produces = "application/json", consumes = "application/json")
    public R<SysUserRoleVO> backQuerySysUserRole(@Validated @RequestBody SysUserRoleQueryParam sysUserRoleQueryParam){
        return R.ok(sysUserRoleService.backQuerySysUserRole(sysUserRoleQueryParam));
        }            

}
