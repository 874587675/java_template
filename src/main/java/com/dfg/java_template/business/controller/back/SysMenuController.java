package com.dfg.java_template.business.controller.back;

import com.dfg.java_template.business.param.list.SysMenuListParam;
import com.dfg.java_template.business.param.page.SysMenuPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysMenuSaveParam;
import com.dfg.java_template.business.param.update.SysMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysMenuVO;
import com.dfg.java_template.business.service.SysMenuService;
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
* 菜单权限 模块
* @author zgc
* @since 2025-05-22 19:02:08
*/
@Api(value = "菜单权限模块", tags = "菜单权限模块相关接口")
@RestController
@RequestMapping("/api/v1/back")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    @PostMapping(value = "/saveSysMenu", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增菜单权限", produces = "application/json", consumes = "application/json")
    public R<?> saveSysMenu(@Validated @RequestBody SysMenuSaveParam sysMenuSaveParam){
        sysMenuService.saveSysMenu(sysMenuSaveParam);
        return R.ok();
    }

    @PostMapping(value = "/updateSysMenu", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改菜单权限", produces = "application/json", consumes = "application/json")
    public R<?> updateSysMenu(@Validated @RequestBody SysMenuUpdateParam sysMenuUpdateParam){
        sysMenuService.updateSysMenu(sysMenuUpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除菜单权限", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/removeSysMenu", produces = "application/json", consumes = "application/json")
    public R<?> removeSysMenu(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        sysMenuService.removeSysMenu(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "查询菜单权限列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/listSysMenu", produces = "application/json", consumes = "application/json")
    public R<List<SysMenuVO>> listSysMenu(@Validated @RequestBody SysMenuListParam sysMenuListParam){
        return R.ok(sysMenuService.listSysMenu(sysMenuListParam));
    }

    @ApiOperation(value = "分页查询菜单权限列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/pageSysMenu", produces = "application/json", consumes = "application/json")
    public R<PageVO<SysMenuVO>> pageSysMenu(@Validated @RequestBody SysMenuPageParam sysMenuPageParam){
        return R.ok(sysMenuService.pageSysMenu(sysMenuPageParam));
    }

    @ApiOperation(value = "查询菜单权限详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/querySysMenu", produces = "application/json", consumes = "application/json")
    public R<SysMenuVO> querySysMenu(@Validated @RequestBody SysMenuQueryParam sysMenuQueryParam){
        return R.ok(sysMenuService.querySysMenu(sysMenuQueryParam));
    }

}
