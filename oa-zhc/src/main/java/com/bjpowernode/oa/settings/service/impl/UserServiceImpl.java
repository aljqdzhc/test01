package com.bjpowernode.oa.settings.service.impl;

import com.bjpowernode.oa.exception.LoginException;
import com.bjpowernode.oa.settings.dao.UserDao;
import com.bjpowernode.oa.settings.daomain.User;
import com.bjpowernode.oa.settings.service.UserService;
import com.bjpowernode.oa.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService  {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String userAct, String usermd5Pwd, String ip) throws LoginException {
        Map<String,String> map =new HashMap<String,String>();
        map.put("userAct", userAct);
        map.put("usermd5Pwd", usermd5Pwd);
        User user = userdao.login(map);
        if (user==null){
            throw new LoginException("账号密码错误");
        }
        System.out.println("2131");
        return user;
    }
}
