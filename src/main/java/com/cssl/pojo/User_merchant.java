package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商家用户表
 */
@Setter
@Getter
public class User_merchant implements Serializable {
    private  int um_id;//商家id
    private String um_username;//商家用户名
    private String um_pwd;//商家密码
    private String um_image;//商家图片
    private String um_name;//商家姓名
    private String um_phone;//商家电话
    private String um_address;//商家地址
    private Date um_time;//注册时间
    //店铺里面有商品的集合
    private List<Commodity> commodityList;

}
