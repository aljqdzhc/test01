package com.bjpowernode.oa.settings.web.contorller;

import com.bjpowernode.oa.exception.LoginException;
import com.bjpowernode.oa.settings.daomain.User;
import com.bjpowernode.oa.settings.service.UserService;
import com.bjpowernode.oa.settings.service.impl.UserServiceImpl;
import com.bjpowernode.oa.utils.MD5Util;
import com.bjpowernode.oa.utils.PrintJson;
import com.bjpowernode.oa.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();

        if("/settings/user/login.do".equals(path)){
            login(request,response);

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("123");
        String userAct = request.getParameter("userAct");
        String userPwd = request.getParameter("userPwd");
        String usermd5Pwd = MD5Util.getMD5(userPwd);
        //接收浏览器端的ip地址
        String ip = request.getRemoteAddr();

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
       /* try {
            User user = us.login(userAct, usermd5Pwd, ip);
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response, true);
        } catch (LoginException e) {
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }*/


        try {
            User user = us.login(userAct,usermd5Pwd,ip);
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);
        }catch (LoginException e){
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }
    }
}
