package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.cssl.pojo.News;
import com.cssl.pojo.Users;
import com.cssl.service.NewsService;
import com.cssl.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService usersService;
    @Autowired
    private NewsService newsService;

    @ResponseBody
    @RequestMapping("/login")
    public  String Login(Users users, HttpSession session, Model mod) {
        System.out.println(users.getU_name());
        return "init";

    }

    @ResponseBody
    @RequestMapping("/init")
    public  String init(Users users, HttpSession session, Model mod) {
        System.out.println(users.getU_name());
        return "index";

    }
    //查询新闻
    @RequestMapping("/selectNews")
    public String selectAllNews(@RequestParam(defaultValue = "1",value ="pageNum") Integer pageNum, HttpSession session){
        Page page=PageHelper.startPage(pageNum,1);
        List<News> newsList = newsService.selectAll();
        session.setAttribute("map",newsList);
        session.setAttribute("page",page);
        return "new";
    }

    /**
     * 返回到首页的
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping("/selectNews1")
    public String selectAllNews1(@RequestParam(defaultValue = "1",value ="pageNum") Integer pageNum, HttpSession session){
        Page page=PageHelper.startPage(pageNum,5);
        List<News> newsList = newsService.selectAll();
        session.setAttribute("mapNew",newsList);
        session.setAttribute("page",page);
        return "index";
    }
    //模糊查询新闻
    @RequestMapping("/selectByName")
    @ResponseBody
    public String selectByName(@RequestParam(defaultValue = "1",value ="pageNum") Integer pageNum,Integer pageno,Model mod,HttpSession session,String vaa){
        Page page=PageHelper.startPage(pageNum,1);
        List<News> selectByName = newsService.selectByName(vaa);
        String json= JSON.toJSONString(selectByName);
        return json;

    }


}
