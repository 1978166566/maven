package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

@Setter
@Getter
public class kkk implements Serializable {
    @Field
    private int cy_id;
    private String cy_name;
    private float cy_price;
    private int cy_sales;
    private String p_imadge;
}
