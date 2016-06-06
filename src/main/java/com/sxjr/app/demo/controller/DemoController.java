package com.sxjr.app.demo.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjr.app.demo.entity.TbDemo;
import com.sxjr.app.demo.service.IDemoService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/demo")
public class DemoController {
    @Autowired
    IDemoService iDemoService;
    
    @RequestMapping(value = "toAdd")
    public String toAdd(ModelMap modelMap){
        return "demo/add";
    }

    @Test
    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
//        Example example = new Example(TbDemo.class);
//        example.createCriteria().andCondition("id>1");
        java.util.List<TbDemo> list = iDemoService.list();
        modelMap.put("lists", list);
        return "demo/list";
    }
    
}
