package com.sxjr.app.conduit.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.conduit.entity.Conduit;
import com.sxjr.app.conduit.service.ConduitService;
import com.sxjr.common.util.RedisUtil;
import com.sxjr.sso.vo.EmployeeVo;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/conduit")
public class ConduitController {
	
	private String PAGE_ADD = "conduit/add";
	private String PAGE_LIST = "conduit/list";
	private String PAGE_EDIT = "conduit/edit";
	
	private String redisKey = "conduit";
	
    @Autowired
    ConduitService conduitService;
    @Autowired
    RedisUtil redisUtil;
    
    @RequestMapping(value = "toAdd")
    public String toAdd(ModelMap modelMap){
    	modelMap.put("errorMsg", "yes");
        return PAGE_ADD;	
    }
    
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request,ModelMap modelMap){
    	String conduitId = request.getParameter("conduitId");
        Conduit model = conduitService.findByConduitId(conduitId);
        if(model != null){
        	modelMap.put("errorMsg", "no");
        	return PAGE_ADD;
        }
    	Conduit conduit = new Conduit();
    	conduit.setName(request.getParameter("name"));
    	conduit.setConduitId(request.getParameter("conduitId"));
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setLongMessage(request.getParameter("longMessage"));
    	conduit.setBulkMessage(request.getParameter("bulkMessage"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setCreateDate(new Date());
//    	conduit.setCreateBy(((EmployeeVo)request.getSession().getAttribute("loginUser")).getLoginName());
    	conduit.setCreateBy("wrq");
    	conduitService.save(conduit);
    	String key = redisKey;
    	String hashKey = request.getParameter("conduitId");
    	String obj = JSON.toJSON(conduit).toString(); 
    	redisUtil.setHash(key, hashKey, obj);
    	List<Conduit> list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
        List<Conduit> list = conduitService.list();
        modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "toEdit")
    public String edit(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
        Conduit model = conduitService.findOne(id);
        modelMap.put("model", model);
        return PAGE_EDIT;
    }
    
    @RequestMapping(value = "update")
    public String update(HttpServletRequest request,ModelMap modelMap){
    	Conduit conduit = new Conduit();
    	conduit.setId(request.getParameter("id"));
    	conduit.setName(request.getParameter("name"));
//    	conduit.setConduitId(request.getParameter("conduitId")); //通道ID不可以修改
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setLongMessage(request.getParameter("longMessage"));
    	conduit.setBulkMessage(request.getParameter("bulkMessage"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setUpdateDate(new Date());
    	conduit.setUpdateBy(((EmployeeVo)request.getSession().getAttribute("loginUser")).getLoginName());
    	conduitService.update(conduit);
    	List list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "delete")
    public String delete(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
    	conduitService.delete(id);
    	List list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "checkConduit")
    public void checkConduit(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	String conduitId = request.getParameter("conduitId");
        Conduit model = conduitService.findByConduitId(conduitId);
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json");
        response.getWriter().write("{\"data\":success}");
        response.getWriter().flush();
    }

}
