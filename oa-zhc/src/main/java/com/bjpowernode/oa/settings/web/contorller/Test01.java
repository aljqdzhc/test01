package com.bjpowernode.oa.settings.web.contorller;

import com.bjpowernode.oa.utils.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        String expiretime = "2020-12-28 10:10:11";
        //Date date = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = DateTimeUtil.getSysTime();
        System.out.println(currentTime);
        int count = expiretime.compareTo(currentTime);
        System.out.println(count);
        if (0 > count){
            System.out.println("您的账号已过期");
        }
    }
}
