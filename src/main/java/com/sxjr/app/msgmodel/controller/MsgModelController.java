package com.sxjr.app.msgmodel.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjr.app.msgmodel.entity.MsgModel;
import com.sxjr.app.msgmodel.service.MsgModelService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/msgmodel")
public class MsgModelController {
	
	private String PAGE_ADD = "msgmodel/add";
	private String PAGE_LIST = "msgmodel/list";
	private String PAGE_EDIT = "msgmodel/edit";
	
    @Autowired
    MsgModelService msgModelService;
    
    @RequestMapping(value = "toAdd")
    public String toAdd(){
        return PAGE_ADD;
    }
    
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request,ModelMap modelMap){
    	String content = request.getParameter("content");
    	String enable = request.getParameter("enable");
    	MsgModel model = new MsgModel();
    	model.setContent(content);
    	model.setEnable(enable);
    	model.setCreateDate(new Date());
    	msgModelService.save(model);
    	List list = msgModelService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
        List<MsgModel> list = msgModelService.list();
        modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "toEdit")
    public String edit(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
        MsgModel model = msgModelService.findOne(id);
        modelMap.put("model", model);
        return PAGE_EDIT;
    }
    
    @RequestMapping(value = "update")
    public String update(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
    	String content = request.getParameter("content");
    	MsgModel model = new MsgModel();
    	model.setContent(content);
    	model.setId(id);
    	msgModelService.update(model);
    	List list = msgModelService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }
    
    @RequestMapping(value = "delete")
    public String delete(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
    	msgModelService.delete(id);
    	List list = msgModelService.list();
    	modelMap.put("lists", list);
        return PAGE_LIST;
    }

}
