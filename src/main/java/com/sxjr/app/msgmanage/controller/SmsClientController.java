package com.sxjr.app.msgmanage.controller;

import java.util.List;

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
		smClientInfo.setStatus(smClientInfo.getStatus());
		smClientInfo.setIPList(request.getRemoteAddr());
		smClientInfo.setAssessSecret(TicketUtil.UUID());
		modelMap.put("result", smsManageService.addClient(smClientInfo));
		List<SmClientInfo> smClientInfos=smsManageService.list();
		modelMap.put("list", smClientInfos);
		return "msgmanage/list";
	}

	@RequestMapping(value = "toAdd")
	public String toAdd() {
		return "msgmanage/addClient";
	}
	
	@RequestMapping(value = "qrylist")
	public String  qryClient(ModelMap modelMap) {
		List<SmClientInfo> smClientInfos=smsManageService.list();
		modelMap.put("list", smClientInfos);
		
		return "msgmanage/list";
		
	}

}
