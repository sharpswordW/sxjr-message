package com.sxjr.app.msgmanage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.msgmanage.service.SmsManageService;
import com.sxjr.app.until.TicketUtil;


/**
 * Created by outh on 2016/6/2.
 */
@Controller
@RequestMapping(value = "app/sms")
public class SmsClientController {

	@Autowired
	private SmsManageService smsManageService;

	@RequestMapping(value = "save")
	public String addClient(HttpServletRequest request,SmClientInfo smClientInfo,ModelMap modelMap) {
		smClientInfo.setAssessToken(TicketUtil.UUID());
		smClientInfo.setState("0");
		smClientInfo.setIPList(request.getRemoteAddr());
		smClientInfo.setAssessSecret(TicketUtil.UUID());
		modelMap.put("result", smsManageService.addClient(smClientInfo));
		return "page/addClient";
	}

	@RequestMapping(value = "toAdd")
	public String toAdd() {
		return "msgmanage/addClient";
	}

}
