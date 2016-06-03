package com.sxjrmsg.app.msgmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String save(){
        return "msgmodel/list";
    }

}
