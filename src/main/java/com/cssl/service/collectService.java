package com.cssl.service;

import com.cssl.pojo.User_collect;
import com.cssl.pojo.Users;

import java.util.List;
import java.util.Map;
/**
 * 我的收藏
 */
public interface collectService {
    //查询用户
    public Users selectUsers(Integer uid);

    //然后根据我收藏的店铺id,查找这个店铺的下面的商品信息
    public List<User_collect> selectAllShopProduct(Integer uid);

    //查询全部收藏商品的信息
    public List<Map<String,Object>> collectThing(Integer uid);

    //搜索框 ,根据商品名称或者商品编号搜索的
    public List<Map<String,Object>> selectBySouSuo(String cyname);


}
