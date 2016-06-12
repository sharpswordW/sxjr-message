package com.sxjr.app.conduit.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sxjr.message.inerface.model.SmsConduit;
import org.sxjr.message.inerface.service.ConduitService;

import com.alibaba.fastjson.JSON;
import com.sxjr.common.util.RedisUtil;
import com.sxjr.sso.vo.EmployeeVo;

/**
 * 通道管理Controller
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
    /**
     * 前往新增页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toAdd")
    public String toAdd(ModelMap modelMap){
    	modelMap.put("errorMsg", "yes");
        return PAGE_ADD;	
    }
    /**
     * 新增操作
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request,ModelMap modelMap){
    	String conduitId = request.getParameter("conduitId");
    	SmsConduit model = conduitService.findByConduitId(conduitId);
        if(model != null){
        	modelMap.put("errorMsg", "no");
        	return PAGE_ADD;
        }
        SmsConduit conduit = new SmsConduit();
    	conduit.setName(request.getParameter("name"));
    	conduit.setConduitId(request.getParameter("conduitId"));
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setIsLong(request.getParameter("isLong"));
    	conduit.setIsBulk(request.getParameter("isBulk"));
    	conduit.setPhoneTimeSpan(request.getParameter("PhoneTimeSpan"));
    	conduit.setPhoneMaxCount(request.getParameter("PhoneMaxCount"));
    	conduit.setMaxLength(request.getParameter("MaxLength"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setCreateDate(new Date());
    	conduit.setCreateBy(((EmployeeVo)request.getSession().getAttribute("loginUser")).getLoginName());
    	conduit.setState("1");
    	conduitService.save(conduit);
    	String key = redisKey;
    	String hashKey = request.getParameter("conduitId");
    	String obj = JSON.toJSON(conduit).toString(); 
    	redisUtil.HSET(key, hashKey, obj);
    	List<SmsConduit> list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    /**
     * 列表
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
        List<SmsConduit> list = conduitService.list();
        modelMap.put("lists", list);
        return PAGE_LIST;
    }
    /**
     * 前往修改页面
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toEdit")
    public String edit(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
    	SmsConduit model = conduitService.findOne(id);
        modelMap.put("model", model);
        return PAGE_EDIT;
    }
    /**
     * 更新操作
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "update")
    public String update(HttpServletRequest request,ModelMap modelMap){
    	SmsConduit conduit = new SmsConduit();
    	conduit.setId(request.getParameter("id"));
    	conduit.setName(request.getParameter("name"));
//    	conduit.setConduitId(request.getParameter("conduitId")); //通道ID不可以修改
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setIsLong(request.getParameter("isLong"));
    	conduit.setIsBulk(request.getParameter("isBulk"));
    	conduit.setPhoneTimeSpan(request.getParameter("PhoneTimeSpan"));
    	conduit.setPhoneMaxCount(request.getParameter("PhoneMaxCount"));
    	conduit.setMaxLength(request.getParameter("MaxLength"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setUpdateDate(new Date());
    	conduit.setUpdateBy(((EmployeeVo)request.getSession().getAttribute("loginUser")).getLoginName());
    	conduitService.update(conduit);
    	String key = redisKey;
    	String hashKey = request.getParameter("conduitId");
    	String obj = JSON.toJSON(conduit).toString(); 
    	redisUtil.HSET(key, hashKey, obj);
    	List list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    /**
     * 删除操作
     * @param request
     * @param modelMap
     * @return
     */
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
    	SmsConduit model = conduitService.findByConduitId(conduitId);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("{\"data\":success}");
        response.getWriter().flush();
    }
    /**
     * 启用/禁用
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "disable")
    public String disable(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
    	String state = request.getParameter("state");
    	conduitService.updateStateById(id, state);
    	List list = conduitService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
}
