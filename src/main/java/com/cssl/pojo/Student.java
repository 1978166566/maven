package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Student implements Serializable {
    @Field //--------使用这个注释，里面的名字是根据你在solr数据库中配置的来决定
    private String id;
    private String code;
    private Date createTime;
    private String name;
}
