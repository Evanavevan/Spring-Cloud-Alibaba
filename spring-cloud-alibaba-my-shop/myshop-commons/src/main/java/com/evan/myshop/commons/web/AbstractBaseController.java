package com.evan.myshop.commons.web;

import com.evan.myshop.commons.dto.AbstractBaseDomain;
import com.evan.myshop.commons.dto.AbstractBaseResult;
import com.evan.myshop.commons.dto.BaseResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用的控制器
 */
public abstract class AbstractBaseController<T extends AbstractBaseDomain> {

    // 用于动态获取配置文件的属性值
    private static final String ENVIRONMENT_LOGGING_LEVEL_MY_SHOP = "logging.level.com.evan.myshop";

    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * 初始化
     * @param request {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     */
    @ModelAttribute
    public void initReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 请求成功
     * @param self  {@link String}
     * @param attribute {@link T}
     * @return
     */
    protected AbstractBaseResult success(String self, T attribute) {
        return BaseResultFactory.getInstance(response).build(self, attribute);
    }

    /**
     * 请求成功
     * @param self {@link String}
     * @param next {@link int}
     * @param last {@link int}
     * @param attributes {@link List}
     * @return
     */
    protected AbstractBaseResult success(String self, int next, int last, List<T> attributes) {
        return BaseResultFactory.getInstance(response).build(self, next, last, attributes);
    }

    /**
     * 请求失败
     * @param title {@link String}
     * @param detail {@link String}
     * @return
     */
    protected AbstractBaseResult error(String title, String detail) {
        return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
    }

    /**
     * 请求失败
     * @param code {@link int}
     * @param title {@link String}
     * @param detail {@link String}
     * @return
     */
    protected AbstractBaseResult error(int code, String title, String detail) {
        return BaseResultFactory.getInstance(response).build(code, title, detail, applicationContext.getEnvironment().getProperty(ENVIRONMENT_LOGGING_LEVEL_MY_SHOP));
    }
}
