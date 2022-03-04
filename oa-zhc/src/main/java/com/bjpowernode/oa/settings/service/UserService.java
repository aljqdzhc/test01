package com.bjpowernode.oa.settings.service;

import com.bjpowernode.oa.exception.LoginException;
import com.bjpowernode.oa.settings.daomain.User;

public interface UserService {


    User login(String userAct, String usermd5Pwd, String ip) throws LoginException;
}
