package com.evan.myshop.commons.mapper;

import com.evan.myshop.commons.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 */
@Repository
public interface TbUserMapper {
    /**
     * 登录
     * @param tbUser {@link TbUser}
     * @return
     */
    TbUser login(TbUser tbUser);

    /**
     * 根据 ID 测试查询用户信息
     * @param id {@link long}
     * @return
     */
    TbUser selectByPrimaryKey(long id);
}
