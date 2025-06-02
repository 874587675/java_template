package com.dfg.java_template.business.param.page.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "分页查询返回对象",description = "分页查询返回对象数据类型")
public class PageVO<T> implements Serializable {
    @ApiModelProperty(value = "总记录数")
    private Long total;

    @ApiModelProperty(value = "总页数")
    private Long pages;

    @ApiModelProperty(value = "当前页数据")
    private Long pageNo;

    @ApiModelProperty(value = "每页数据")
    private Long pageSize;

    @ApiModelProperty(value = "当前页数据列表")
    private List<T> list;

    /**
     * 分页数据封装
     * @param page  分页数据信息
     * @param list  当前页数据列表
     * @return 封装分页数据
     * @param <T>   分页数据信息类型
     * @param <X>   当前页数据类型
     */
    public static <T,X> PageVO<T> addPageData(Page<X> page, List<T> list) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setTotal(page.getTotal());
        pageVO.setPages(page.getPages());
        pageVO.setPageNo(page.getCurrent());
        pageVO.setPageSize(page.getSize());
        pageVO.setList(list);
        return pageVO;
    }


}
