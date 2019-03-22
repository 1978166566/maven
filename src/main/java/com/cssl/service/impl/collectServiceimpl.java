package com.cssl.service.impl;

import com.cssl.dao.collectDao;
import com.cssl.pojo.User_collect;
import com.cssl.pojo.Users;
import com.cssl.service.collectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class collectServiceimpl implements collectService {

    @Autowired
    private collectDao collectDao;

    @Override
    public Users selectUsers(Integer uid) {
        return collectDao.selectUsers(uid);
    }

    @Override
    public List<User_collect> selectAllShopProduct(Integer uid) {
        return collectDao.selectAllShopProduct(uid);
    }

    @Override
    public List<Map<String, Object>> collectThing(Integer uid) {
        return collectDao.collectThing(uid);
    }

    @Override
    public List<Map<String, Object>> selectBySouSuo(String cyname) {
        return collectDao.selectBySouSuo(cyname);
    }
}
