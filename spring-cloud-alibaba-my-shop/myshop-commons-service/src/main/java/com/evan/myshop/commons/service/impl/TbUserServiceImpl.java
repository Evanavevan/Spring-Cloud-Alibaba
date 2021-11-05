package com.evan.myshop.commons.service.impl;

import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.commons.mapper.TbUserMapper;
import com.evan.myshop.commons.service.TbUserService;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl extends BaseCrudServiceImpl<TbUser, TbUserMapper> implements TbUserService {
}
