package com.bjpowernode.oa.settings.web.contorller;

import com.bjpowernode.oa.exception.LoginException;
import com.bjpowernode.oa.settings.daomain.User;
import com.bjpowernode.oa.settings.service.UserService;
import com.bjpowernode.oa.settings.service.impl.UserServiceImpl;
import com.bjpowernode.oa.utils.DateTimeUtil;
import com.bjpowernode.oa.utils.ServiceFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        String expiretime = "2020-12-28 10:10:11";
        //Date date = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = DateTimeUtil.getSysTime();

        int count = expiretime.compareTo(currentTime);
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try{

            User user = us.login("123","12321","123213");
            System.out.println(currentTime);
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.println(count);
        }


        if (0 > count){
            System.out.println("您的账号已过期");
        }
    }
}
