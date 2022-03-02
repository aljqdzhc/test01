package com.bjpowernode.oa.settings.service.impl;

import com.bjpowernode.oa.settings.dao.UserDao;
import com.bjpowernode.oa.settings.service.UserService;
import com.bjpowernode.oa.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}
