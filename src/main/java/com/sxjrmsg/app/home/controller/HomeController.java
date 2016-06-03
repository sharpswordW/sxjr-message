package com.sxjrmsg.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangrq on 2016/6/2.
 */
@Controller
@RequestMapping(value = "")
public class HomeController {

    @RequestMapping(value = "home")
    public String list(ModelMap modelMap){
        return "index";
    }
    
}
