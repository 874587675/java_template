package com.dfg.java_template.framework.generate.abstracts;


/**
 * 参数转换器
 * @author zgc
 */
public interface AbstractConvertor<SaveParam, UpdateParam, VO, Entity, ListEntity, ListVO> {

    /**
     * SaveParam转化为Entity
     *
     * @param saveParam 保存参数
     * @return Entity
     */
    Entity saveParamToEntity(SaveParam saveParam);

    /**
     * UpdateParam转化为Entity
     *
     * @param updateParam 修改参数
     * @return Entity
     */
    Entity updateParamToEntity(UpdateParam updateParam);

    /**
     * Entity转化为VO
     *
     * @param entity 实体类
     * @return VO
     */
    VO entityToVo(Entity entity);

    /**
     * ListEntity转化为ListVO
     *
     * @param listEntity 列表实体类
     * @return ListVO
     */
    ListVO listEntityToListVO(ListEntity listEntity);


}
