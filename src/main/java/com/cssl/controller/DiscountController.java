package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.cssl.pojo.Commodity;
import com.cssl.service.discountProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class DiscountController {

    @Autowired
    private discountProductService discountProductService;

    /**
     * 限时抢购的信息,根据打折的折扣来排序
     * @param session
     * @return
     */
    @RequestMapping("/flashSale")
    public String flashSale(Integer pageNo, HttpSession session){
        List<Map<String, Object>> mapList = discountProductService.selectFlashSale(pageNo);
        PageHelper.startPage(pageNo == null ? 1 : pageNo, 4);
        session.setAttribute("mapList",mapList);
        return "index";
    }

    /**
     * 热卖 根据销量来排序
     * @param pageNo
     * @param session
     * @return
     */
    @RequestMapping("/hostSale")
    public String hostSale(Integer pageNo,HttpSession session){
        List<Map<String, Object>> mapList1 = discountProductService.selectHostSale(pageNo);
        PageHelper.startPage(pageNo==null ?1:pageNo,6);
        session.setAttribute("mapList2",mapList1);
        return "index";
    }


    /**
     * 根据id查询这个商品的详情信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/discountProduct")
    public String commodity(Integer id, HttpSession session,Integer cyid){
        Map<String,Object> commodity= discountProductService.selectCommdity(id);
        session.setAttribute("commodity",commodity);
        return "forward:buyPage";
    }

    /**
     * 根据版本号查询信息
     * @param id
     * @param session
     * @param cyid
     * @return
     */
    @RequestMapping("/buyPage")
    public String commodity1(Integer id,HttpSession session,Integer cyid){
        List<Map<String, Object>> selectBuyPage = discountProductService.selectBuyPage(cyid);
        session.setAttribute("selectBuyPage",selectBuyPage);
        return "forward:selectDiscuss";
    }
    @RequestMapping("/selectDiscuss")
    public String selectDiscuss(Integer cyid, Model model,HttpSession session){
        List<Map<String, Object>> selectDiscuss = discountProductService.selectDiscuss(cyid);
        session.setAttribute("cyid",cyid);
        model.addAttribute("selectDiscuss",selectDiscuss);
        return "page";
    }
    @RequestMapping("/selectHaoPing")
    @ResponseBody
    public String selectHaoPing(HttpSession session){
        Integer cyid=(Integer)session.getAttribute("cyid");
        List<Map<String, Object>> haoPing = discountProductService.selectHaoPing(cyid);
        session.setAttribute("haoPing",haoPing);
        String json=JSON.toJSONString(haoPing);
        return json;
    }

    @RequestMapping("/selectZhongPing")
    @ResponseBody
    public String selectZhongPing(HttpSession session){
        Integer cyid=(Integer)session.getAttribute("cyid");
        List<Map<String, Object>> zhongPing = discountProductService.selectZhongPing(cyid);
        session.setAttribute("zhongPing",zhongPing);
        String json=JSON.toJSONString(zhongPing);
        return json;
    }

    @RequestMapping("/selectChaPing")
    @ResponseBody
    public String selectChaPing(HttpSession session){
        Integer cyid=(Integer)session.getAttribute("cyid");
        List<Map<String, Object>> chaPing = discountProductService.selectChaPing(cyid);
        session.setAttribute("chaPing",chaPing);
        String json=JSON.toJSONString(chaPing);
        return json;
    }

}
