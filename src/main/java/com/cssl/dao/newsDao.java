package com.cssl.dao;

import com.cssl.pojo.News;

import java.util.List;

/**
 * 新闻快讯表
 */
public interface newsDao {
    //查询所有的新闻 int pageSzie,int pageNo
    public List<News> selectAll();

    //根据关键字搜索
    public List<News> selectByName(String keyword);
}
