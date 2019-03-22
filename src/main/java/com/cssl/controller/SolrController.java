package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cssl.pojo.Commodity;
import com.cssl.pojo.Two_class;
import com.cssl.pojo.User_collect;
import com.cssl.service.SolrService;
import com.cssl.util.Message;
import com.github.pagehelper.PageHelper;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SolrController {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private SolrService solrService;
    @RequestMapping("/selectAll")
    public String selectAll(String cyname, HttpSession session) {
        Query query;
        if (cyname != null && cyname!="") {
            query = new SimpleQuery("*:*");
            Criteria cri = new Criteria("cy_name").contains(cyname);
            //条件追加
//        cri = cri.and("cy_price").between(14, 24);
            query.addCriteria(cri);
            //分页，默认1-10条
            query.setOffset(0L);
            query.setRows(8);
        }else{
            query = new SimpleQuery("*:*");
            Criteria cri = new Criteria("cy_name").contains("小米");
            //条件追加
//        cri = cri.and("cy_price").between(14, 24);
            query.addCriteria(cri);
            //分页，默认1-10条
            query.setOffset(0L);
            query.setRows(8);
        }
        ScoredPage<Map> test_core = solrTemplate.queryForPage("wx", query, Map.class);
        System.out.println(test_core);
        session.setAttribute("testCore", test_core);

        /*----------------------------------------------------------------*/
        List<Map<String, Object>> mapList = solrService.selectFlat(3);
        List<Map<String, Object>> selectCsSize = solrService.selectCsSize();
        List<Map<String, Object>> selectCsSystem = solrService.selectCsSystem();
        session.setAttribute("mapList",mapList);
        session.setAttribute("selectCsSize",selectCsSize);
        session.setAttribute("selectCsSystem",selectCsSystem);
        return "all-class";
    }


    @RequestMapping("/selectFlat")
    public String selectFlat(HttpSession session,String flatname){
        String kk=flatname.substring(0,2);
        PageHelper.startPage(1,8);
        List<Map<String, Object>> mapList2 = solrService.selectFlatProduct(kk);
        session.setAttribute("mapList2",mapList2);
        return "all-class1";
    }

    @RequestMapping("/selectProductSize")
    public String selectProductSize(HttpSession session,String scSize){
        PageHelper.startPage(1,8);
        List<Map<String, Object>> mapList2 = solrService.selectProductSize(scSize);
        session.setAttribute("mapList2",mapList2);
        return "all-class1";
    }

    @RequestMapping("/selectSystem")
    public String selectSystem(HttpSession session,String scSystem){
        String kk=scSystem.substring(0,2);
        List<Map<String, Object>> mapList2 = solrService.selectSystem(kk);
        session.setAttribute("mapList2",mapList2);
        return "all-class1";
    }

    /**
     * 按照销量
     * @param
     * @return
     */
    @RequestMapping("/selectSalesOrder")
    @ResponseBody
    public String selectSalesOrder(){
        List<Map<String, Object>> mapList2 = solrService.selectSalesOrder();
        String json=JSON.toJSONString(mapList2);
        return json;
    }
    /**
     * 根据价格排序
     * @return
     */
    @RequestMapping("/selectPriceOrder")
    @ResponseBody
    public String selectPriceOrder(){
        List<Map<String, Object>> mapList2 = solrService.selectPriceOrder();
        String json=JSON.toJSONString(mapList2);
        return json;
    }
    /**
     * 根据商家时间排序
     * @return
     */
    @RequestMapping("/selectTmeOrder")
    @ResponseBody
    public String selectTmeOrder(HttpSession session){
        List<Map<String, Object>> mapList2 = solrService.selectTimeOrder();
        String json=JSON.toJSONString(mapList2);
        return json;
    }

    /**
     * 查找存货大于0的商品
     * @return
     */
    @RequestMapping("selectInventory")
    @ResponseBody
    public String selectInventory(){
        List<Map<String, Object>> mapList2 = solrService.selectInventory();
        String json=JSON.toJSONString(mapList2);
        return json;
    }

    @RequestMapping("/insertCollect")
    @ResponseBody
    public String insertCollect(Integer cyid){
        User_collect user_collect=new User_collect();
        user_collect.setC_pid(cyid);
        user_collect.setUm_id(1);
        user_collect.setU_id(1);
        int i = solrService.insertCollect(user_collect);
        String json=JSON.toJSONString(i);
        return json;
    }

    /**
     * 根据搜索框里面的东西查询
     * @param cy_name
     * @param cy_price
     * @param cy_price1
     * @return
     */
    @RequestMapping("/selectSouSuo")
    @ResponseBody
    public JSON selectSouSuo(String cy_name,double cy_price,double cy_price1){
        System.out.println(cy_name);
        System.out.println(cy_price);
        System.out.println(cy_price1);
        Map<String,Object> map = new HashMap<>();
        map.put("cy_name",cy_name);
        map.put("cy_price",cy_price);
        map.put("cy_price1",cy_price1);
        PageHelper.startPage(1,8);
        List<Map<String, Object>> mapList2 = solrService.selectSouSuo(map);
        System.out.println("aaa"+mapList2.size());
        JSONObject json = new JSONObject();
        json.put("result",mapList2);
        /*json 传值的格式*/
//        String json=JSON.toJSONString(mapList2);
//        System.out.println(json);
        return json;
    }

}
