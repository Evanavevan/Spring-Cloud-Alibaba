package com.evan.myshop.service.reg.controller;

import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.commons.dto.AbstractBaseResult;
import com.evan.myshop.commons.service.TbUserService;
import com.evan.myshop.commons.validator.BeanValidator;
import com.evan.myshop.commons.web.AbstractBaseController;
import com.evan.myshop.service.reg.service.RegService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<TbUser> {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private RegService regService;

    /**
     * 用户注册
     * @param tbUser {@link TbUser}
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "以实体类为参数，注意用户名和邮箱不要重复")
    @PostMapping(value = "")
    public AbstractBaseResult reg(@ApiParam(name = "tbUser", value = "用户模型") TbUser tbUser) {
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }

        // 验证用户名是否重复
        if (!tbUserService.unique("username", tbUser.getUsername())) {
            return error("用户名重复，请重试", null);
        }

        // 验证邮箱是否重复
        if (!tbUserService.unique("email", tbUser.getEmail())) {
            return error("邮箱重复，请重试", null);
        }

        // 设置密码加密
        if (StringUtils.isNotBlank(tbUser.getPassword())) {
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        }
        // 密码为空
        else {
            return error("密码不可为空", null);
        }
        // 注册用户
        TbUser user = tbUserService.save(tbUser);
        if (user != null) {
            response.setStatus(HttpStatus.CREATED.value());
            // 发送注册成功通知到消息队列
            regService.sendEmail(user);
            return success(request.getRequestURI(), user);
        }

        // 注册失败
        return error("注册失败，请重试", null);
    }
}
