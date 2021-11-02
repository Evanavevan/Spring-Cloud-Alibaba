package com.evan.myshop.commons.domain;

import lombok.Data;

/**
 * 内容管理
 */
@Data
public class TbContent {
    private String title;

    private String subTitle;

    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    private String content;

    private TbContentCategory tbContentCategory;
}
