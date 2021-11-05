package com.evan.myshop.commons.service;

import com.evan.myshop.commons.dto.AbstractBaseDomain;

/**
 * 通用的业务逻辑
 */
public interface BaseCrudService<T extends AbstractBaseDomain> {
    /**
     * 查询属性值是否唯一
     *
     * @param property {@link String}
     * @param value {@link String}
     * @return true/唯一，false/不唯一
     */
    default boolean unique(String property, String value) {
        return false;
    }

    /**
     * 保存
     * @param domain {@link T}
     * @return
     */
    default T save(T domain) {
        return null;
    }
}
