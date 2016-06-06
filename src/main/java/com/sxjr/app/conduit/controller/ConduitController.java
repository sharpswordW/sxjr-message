package com.sxjr.app.conduit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjr.app.conduit.entity.Conduit;
import com.sxjr.app.conduit.service.ConduitService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/conduit")
public class ConduitController {
	
	private String PAGE_ADD = "conduit/add";
	private String PAGE_LIST = "conduit/list";
	private String PAGE_EDIT = "conduit/edit";
	
    @Autowired
    ConduitService conduitService;
    
    @RequestMapping(value = "toAdd")
    public String toAdd(){
        return PAGE_ADD;
    }
    
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request,ModelMap modelMap){
    	Conduit conduit = new Conduit();
    	conduit.setName(request.getParameter("name"));
    	conduit.setConduitId(request.getParameter("conduitId"));
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setLongMessage(request.getParameter("longMessage"));
    	conduit.setBulkMessage(request.getParameter("bulkMessage"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setCreateDate(new Date());
    	conduitService.save(conduit);
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
    	String id = request.getParameter("id");
    	String content = request.getParameter("content");
    	Conduit conduit = new Conduit();
    	conduit.setId(request.getParameter("id"));
    	conduit.setName(request.getParameter("name"));
    	conduit.setConduitId(request.getParameter("conduitId"));
    	conduit.setAccount(request.getParameter("name"));
    	conduit.setPassword(request.getParameter("password"));
    	conduit.setLongMessage(request.getParameter("longMessage"));
    	conduit.setBulkMessage(request.getParameter("bulkMessage"));
    	conduit.setPriority(request.getParameter("priority"));
    	conduit.setCreateDate(new Date());
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

}
