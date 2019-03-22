package com.cssl.service.impl;

import com.cssl.dao.SolrDao;
import com.cssl.pojo.User_collect;
import com.cssl.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SolrServiceimpl implements SolrService {
    @Autowired
    private SolrDao solrDao;

    @Override
    public List<Map<String, Object>> selectFlat(Integer ocId) {
        return solrDao.selectFlat(ocId);
    }

    @Override
    public List<Map<String, Object>> selectCsSize() {
        return solrDao.selectCsSize();
    }

    @Override
    public List<Map<String, Object>> selectCsSystem() {
        return solrDao.selectCsSystem();
    }

    @Override
    public List<Map<String, Object>> selectFlatProduct(String flatName) {
        return solrDao.selectFlatProduct(flatName);
    }

    @Override
    public List<Map<String, Object>> selectProductSize(String size) {
        return solrDao.selectProductSize(size);
    }

    @Override
    public List<Map<String, Object>> selectSystem(String system) {
        return solrDao.selectSystem(system);
    }

    @Override
    public List<Map<String, Object>> selectSalesOrder() {
        return solrDao.selectSalesOrder();
    }

    @Override
    public List<Map<String, Object>> selectPriceOrder() {
        return solrDao.selectPriceOrder();
    }

    @Override
    public List<Map<String, Object>> selectTimeOrder() {
        return solrDao.selectTimeOrder();
    }

    @Override
    public List<Map<String, Object>> selectInventory() {
        return solrDao.selectInventory();
    }

    @Override
    public List<Map<String, Object>> selectDisCount() {
        return solrDao.selectDisCount();
    }

    @Override
    public int insertCollect(User_collect user_collect) {
        return solrDao.insertCollect(user_collect);
    }

    @Override
    public List<Map<String, Object>> selectSouSuo(Map<String,Object> map) {
        return solrDao.selectSouSuo(map);
    }
}
