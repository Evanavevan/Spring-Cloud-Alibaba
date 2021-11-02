package com.evan.myshop.commons.mapper;

import com.evan.myshop.commons.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentMapper {
    /**
     * 根据类别 ID 查询内容列表
     * @param tbContent {@link TbContent}
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
