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
 * 角色信息 模块
 *
 * @author zgc
 * @since 2025-05-17 19:35:17
 */
@Api(value = "角色信息模块", tags = "角色信息模块相关接口")
@RestController
@RequestMapping("/api/v1/back")
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

    @ApiOperation(value = "查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/listSysRole", produces = "application/json", consumes = "application/json")
    public R<List<SysRoleVO>> listSysRole(@Validated @RequestBody SysRoleListParam sysRoleListParam){
        return R.ok(sysRoleService.listSysRole(sysRoleListParam));
    }

    @ApiOperation(value = "分页查询角色信息列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/pageSysRole", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleVO>> pageSysRole(@Validated @RequestBody SysRolePageParam sysRolePageParam){
        return R.ok(sysRoleService.pageSysRole(sysRolePageParam));
    }

    @ApiOperation(value = "查询角色信息详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/querySysRole", produces = "application/json", consumes = "application/json")
    public R<SysRoleVO> querySysRole(@Validated @RequestBody SysRoleQueryParam sysRoleQueryParam){
        return R.ok(sysRoleService.querySysRole(sysRoleQueryParam));
    }

}
