package com.cssl.dao;

import com.cssl.pojo.Users;

public interface userDao {
    //用户登录
    public Users Login(Users users);

//    //判断用户是否注册
//    public int registerByName(String name);
//
//    //用户注册
//    public int register(Users users);
//
//    //判断用户是否登录
//    public Integer findLogin(Users users);
}
