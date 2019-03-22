package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 分类内容表
 */
@Setter
@Getter
public class Two_class implements Serializable {
    private int tc_id;//分类内容id
    private String tc_content;//分类内容
    private int oc_id;//分类id引用的是二级分类的id
}
