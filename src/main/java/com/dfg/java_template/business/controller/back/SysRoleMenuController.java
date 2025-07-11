package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
import com.dfg.java_template.business.param.page.SysRoleMenuPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysRoleMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;
import com.dfg.java_template.business.service.SysRoleMenuService;
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
* 角色和菜单关联 模块
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Api(value = "角色和菜单关联模块", tags = "角色和菜单关联模块相关接口")
@RestController
@RequestMapping("/api/v1/sysRoleMenu/back")
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

    @ApiOperation(value = "前台用户查询角色和菜单关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontListSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<List<SysRoleMenuVO>> frontListSysRoleMenu(@Validated @RequestBody SysRoleMenuListParam sysRoleMenuListParam){
        return R.ok(sysRoleMenuService.frontListSysRoleMenu(sysRoleMenuListParam));
    }

    @ApiOperation(value = "前台用户分页查询角色和菜单关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPageSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleMenuVO>> frontPageSysRoleMenu(@Validated @RequestBody SysRoleMenuPageParam sysRoleMenuPageParam){
        return R.ok(sysRoleMenuService.frontPageSysRoleMenu(sysRoleMenuPageParam));
    }

    @ApiOperation(value = "前台用户查询角色和菜单关联详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQuerySysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<SysRoleMenuVO> frontQuerySysRoleMenu(@Validated @RequestBody SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return R.ok(sysRoleMenuService.frontQuerySysRoleMenu(sysRoleMenuQueryParam));
    }

    @ApiOperation(value = "后台用户查询角色和菜单关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backListSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<List<SysRoleMenuVO>> backListSysRoleMenu(@Validated @RequestBody SysRoleMenuListParam sysRoleMenuListParam){
        return R.ok(sysRoleMenuService.backListSysRoleMenu(sysRoleMenuListParam));
        }

    @ApiOperation(value = "后台用户分页查询角色和菜单关联列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPageSysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysRoleMenuVO>> backPageSysRoleMenu(@Validated @RequestBody SysRoleMenuPageParam sysRoleMenuPageParam){
        return R.ok(sysRoleMenuService.backPageSysRoleMenu(sysRoleMenuPageParam));
        }
    
    @ApiOperation(value = "后台用户查询角色和菜单关联详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQuerySysRoleMenu", produces = "application/json", consumes = "application/json")
    public R<SysRoleMenuVO> backQuerySysRoleMenu(@Validated @RequestBody SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return R.ok(sysRoleMenuService.backQuerySysRoleMenu(sysRoleMenuQueryParam));
        }            

}
