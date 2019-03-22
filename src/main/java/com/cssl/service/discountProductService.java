package com.cssl.service;

import com.cssl.pojo.Commodity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface discountProductService {

    //限时抢购的信息,根据打折的折扣来排序,分页查询
    public List<Map<String,Object>> selectFlashSale(Integer pageNo);

    //根据id查询商品信息  查询page页面的信息
    public Map<String,Object> selectCommdity(Integer id);

    //热卖区的信息,根据销量多少来排序,分页查询
    public List<Map<String,Object>> selectHostSale(Integer pageNo);

    //查询版本问题  根据版本查找不同的价格
    public List<Map<String,Object>> selectBuyPage(Integer cyid);

    //根据版本查找不同的价格
    public Map<String,Object> selectBuyPage1(Integer cyid,Integer csversion);

    //根据商品id查询评论
    public List<Map<String,Object>> selectDiscuss(Integer cyid);

    public List<Map<String,Object>>selectHaoPing(Integer cyid);

    public List<Map<String,Object>>selectZhongPing(Integer cyid);

    public List<Map<String,Object>>selectChaPing(Integer cyid);
}
