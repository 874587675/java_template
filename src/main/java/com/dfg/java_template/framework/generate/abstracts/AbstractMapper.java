package com.dfg.java_template.framework.generate.abstracts;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;


/**
 * @author zgc
 */

public interface AbstractMapper<T> extends BaseMapper<T> {

    /**
     * 批量新增
     *
     * @param collection 集合参数
     * @return 新增条数
     */
    int insertBatchSomeColumn(Collection<T> collection);

}