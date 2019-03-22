package com.cssl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 商城快讯表
 */
@Setter
@Getter
public class News implements Serializable {
    private int n_id;//新闻id
    private String n_title;//标题
    @DateTimeFormat(pattern="yyyy-MM-dd")//set
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date n_time;//发布时间
    private String n_content;//内容
}
