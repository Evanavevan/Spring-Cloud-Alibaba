package com.evan.myshop.commons.domain;

import lombok.Data;
/**
 * 分类管理
 */
@Data
public class TbContentCategory {
    private String name;
    private Integer status;

    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
