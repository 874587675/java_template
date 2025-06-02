package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysRoleMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;
import com.dfg.java_template.business.service.SysRoleMenuService;
import com.dfg.java_template.framework.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



/**
* 角色和菜单关联 模块
* @author zgc
* @since 2025-05-22 19:02:09
*/
@Api(value = "角色和菜单关联模块", tags = "角色和菜单关联模块相关接口")
@RestController
@RequestMapping("/api/v1/back")
public class SysRoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @PostMapping(value = "/saveSysRoleMenu", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增角色和菜单关联", produces = "application/json", consumes = "application/json")
    public R<?> saveSysRoleMenu(@Validated @RequestBody SysRoleMenuSaveParam sysRoleMenuSaveParam){
        sysRoleMenuService.saveSysRoleMenu(sysRoleMenuSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateSysRoleMenu", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改角色和菜单关联", produces = "application/json", consumes = "application/json")
    public R<?> updateSysRoleMenu(@Validated @RequestBody SysRoleMenuUpdateParam sysRoleMenuUpdateParam){
        sysRoleMenuService.updateSysRoleMenu(sysRoleMenuUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除角色和菜单关联", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<?> removeSysRoleMenu(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        sysRoleMenuService.removeSysRoleMenu(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "查询角色和菜单关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/listSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleMenuVO>> listSysRoleMenu(@Validated @RequestBody SysRoleMenuListParam sysRoleMenuListParam){
        return R.ok(sysRoleMenuService.listSysRoleMenu(sysRoleMenuListParam));
    }

    @ApiOperation(value = "查询角色和菜单关联详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/querySysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<SysRoleMenuVO> querySysRoleMenu(@Validated @RequestBody SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return R.ok(sysRoleMenuService.querySysRoleMenu(sysRoleMenuQueryParam));
    }

}
