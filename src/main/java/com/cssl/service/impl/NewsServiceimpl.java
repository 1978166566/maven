package com.cssl.service.impl;

import com.cssl.pojo.News;
import com.cssl.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceimpl implements NewsService {

    @Autowired
    private com.cssl.dao.newsDao newsDao;

    @Override
    public List<News> selectAll() {
        return newsDao.selectAll();
    }

    @Override
    public List<News> selectByName(String keyword) {
        return newsDao.selectByName(keyword);
    }
}
