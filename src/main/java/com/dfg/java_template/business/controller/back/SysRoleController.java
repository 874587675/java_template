package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysRoleListParam;
import com.dfg.java_template.business.param.page.SysRolePageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysRoleSaveParam;
import com.dfg.java_template.business.param.update.SysRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleVO;
import com.dfg.java_template.business.service.SysRoleService;
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
* 角色信息 模块
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Api(value = "角色信息模块", tags = "角色信息模块相关接口")
@RestController
@RequestMapping("/api/v1/sysRole/back")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @PostMapping(value = "/saveSysRole", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增角色信息", produces = "application/json", consumes = "application/json")
    public R<?> saveSysRole(@Validated @RequestBody SysRoleSaveParam sysRoleSaveParam){
        sysRoleService.saveSysRole(sysRoleSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateSysRole", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改角色信息", produces = "application/json", consumes = "application/json")
    public R<?> updateSysRole(@Validated @RequestBody SysRoleUpdateParam sysRoleUpdateParam){
        sysRoleService.updateSysRole(sysRoleUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除角色信息", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeSysRole", produces = "application/json", consumes = "application/json")
    public R<?> removeSysRole(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        sysRoleService.removeSysRole(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "前台用户查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontListSysRole", produces = "application/json", consumes = "application/json")
    public R<List<SysRoleVO>> frontListSysRole(@Validated @RequestBody SysRoleListParam sysRoleListParam){
        return R.ok(sysRoleService.frontListSysRole(sysRoleListParam));
    }

    @ApiOperation(value = "前台用户分页查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPageSysRole", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleVO>> frontPageSysRole(@Validated @RequestBody SysRolePageParam sysRolePageParam){
        return R.ok(sysRoleService.frontPageSysRole(sysRolePageParam));
    }

    @ApiOperation(value = "前台用户查询角色信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQuerySysRole", produces = "application/json", consumes = "application/json")
    public R<SysRoleVO> frontQuerySysRole(@Validated @RequestBody SysRoleQueryParam sysRoleQueryParam){
        return R.ok(sysRoleService.frontQuerySysRole(sysRoleQueryParam));
    }

    @ApiOperation(value = "后台用户查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backListSysRole", produces = "application/json", consumes = "application/json")
    public R<List<SysRoleVO>> backListSysRole(@Validated @RequestBody SysRoleListParam sysRoleListParam){
        return R.ok(sysRoleService.backListSysRole(sysRoleListParam));
        }

    @ApiOperation(value = "后台用户分页查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPageSysRole", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleVO>> backPageSysRole(@Validated @RequestBody SysRolePageParam sysRolePageParam){
        return R.ok(sysRoleService.backPageSysRole(sysRolePageParam));
        }
    
    @ApiOperation(value = "后台用户查询角色信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQuerySysRole", produces = "application/json", consumes = "application/json")
    public R<SysRoleVO> backQuerySysRole(@Validated @RequestBody SysRoleQueryParam sysRoleQueryParam){
        return R.ok(sysRoleService.backQuerySysRole(sysRoleQueryParam));
        }            

}
