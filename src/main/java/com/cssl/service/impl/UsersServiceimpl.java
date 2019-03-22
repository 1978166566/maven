package com.cssl.service.impl;

import com.cssl.dao.userDao;
import com.cssl.pojo.Users;
import com.cssl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceimpl implements UserService {

    @Resource
    private userDao userdao;
    @Override
    public Users Login(Users users) {
        return userdao.Login(users);
    }

//    @Override
//    public int registerByName(String name) {
//        return userdao.registerByName(name);
//    }
//
//    @Override
//    public int register(Users users) {
//        return userdao.register(users);
//    }
//
//    @Override
//    public Integer findLogin(Users users) {
//        return userdao.findLogin(users);
//    }
}
