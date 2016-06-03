package com.sxjrmsg.app.msgmodel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjrmsg.app.msgmodel.entity.MsgModel;
import com.sxjrmsg.app.msgmodel.service.MsgModelService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/msgmodel")
public class MsgModelController {
    @Autowired
    MsgModelService msgModelService;
    
    @RequestMapping(value = "toAdd")
    public String toAdd(){
        return "msgmodel/add";
    }
    
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request){
    	String content = request.getParameter("content");
    	MsgModel model = new MsgModel();
    	model.setContent(content);
    	msgModelService.save(model);
        return "msgmodel/add";
    }
    
    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
        List<MsgModel> list = msgModelService.list();
        modelMap.put("lists", list);
        return "msgmodel/list";
    }
    
    @RequestMapping(value = "toEdit")
    public String edit(HttpServletRequest request,ModelMap modelMap){
    	String id = request.getParameter("id");
        MsgModel model = msgModelService.findOne(id);
        modelMap.put("model", model);
        return "msgmodel/edit";
    }
    
    @RequestMapping(value = "update")
    public String update(HttpServletRequest request){
    	String id = request.getParameter("id");
    	String content = request.getParameter("content");
    	MsgModel model = new MsgModel();
    	model.setContent(content);
    	model.setId(id);
    	msgModelService.update(model);
        return "msgmodel/list";
    }
    
    @RequestMapping(value = "delete")
    public String delete(HttpServletRequest request){
    	String id = request.getParameter("id");
    	msgModelService.delete(id);
        return "msgmodel/list";
    }

}
