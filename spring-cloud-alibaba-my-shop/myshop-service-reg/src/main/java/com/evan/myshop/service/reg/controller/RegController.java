package com.evan.myshop.service.reg.controller;

import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.commons.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController {

    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 根据 ID 测试查询用户信息
     * @param id {@link long}
     * @return
     */
    @GetMapping(value = {"{id}"})
    public String reg(@PathVariable long id) {
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);
        return tbUser.getUsername();
    }
}
