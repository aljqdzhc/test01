package com.bjpowernode.oa.settings.dao;

import com.bjpowernode.oa.settings.daomain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User login(Map<String, String> map);

}
