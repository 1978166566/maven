package com.cssl.service.impl;

import com.cssl.dao.discountProductDao;
import com.cssl.service.discountProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class discountProductServiceimpl implements discountProductService {

    @Autowired
    private discountProductDao discountProductDao;

    @Override
    public List<Map<String, Object>> selectHostSale(Integer pageNo) {
        return discountProductDao.selectHostSale(pageNo);
    }

    @Override
    public List<Map<String, Object>> selectFlashSale(Integer pageNo) {
        return discountProductDao.selectFlashSale(pageNo);
    }

    @Override
    public Map<String, Object> selectCommdity(Integer id) {
        return discountProductDao.selectCommdity(id);
    }

    @Override
    public List<Map<String, Object>> selectBuyPage(Integer cyid) {
        return discountProductDao.selectBuyPage(cyid);
    }

    @Override
    public Map<String, Object> selectBuyPage1(Integer cyid, Integer csversion) {
        return discountProductDao.selectBuyPage1(cyid,csversion);
    }

    @Override
    public List<Map<String, Object>> selectDiscuss(Integer cyid) {
        return discountProductDao.selectDiscuss(cyid);
    }

    @Override
    public List<Map<String, Object>> selectHaoPing(Integer cyid) {
        return discountProductDao.selectHaoPing(cyid);
    }

    @Override
    public List<Map<String, Object>> selectZhongPing(Integer cyid) {
        return discountProductDao.selectZhongPing(cyid);
    }

    @Override
    public List<Map<String, Object>> selectChaPing(Integer cyid) {
        return discountProductDao.selectChaPing(cyid);
    }
}
