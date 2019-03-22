package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 一级分类信息表
 */
@Setter
@Getter
public class One_class implements Serializable {
    private int oc_id;//分类id
    private String oc_name;//分类名称
    private int oc_fid;//分类名称
    private List<One_class> stair;
    private List<Two_class> second;
}

