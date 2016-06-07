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

	private String PAGE_ADD = "msgmanage/addClient";
	private String PAGE_LIST = "msgmanage/list";
	private String PAGE_EDIT = "msgmanage/edit";

	@RequestMapping(value = "save")
	public String addClient(HttpServletRequest request,
			SmClientInfo smClientInfo, ModelMap modelMap) {
		smClientInfo.setAssessToken(TicketUtil.UUID());
		smClientInfo.setIPList(request.getRemoteAddr());
		smClientInfo.setAssessSecret(TicketUtil.UUID());
		if (smClientInfo.getName() == null || smClientInfo.getStatus() == null) {
			modelMap.put("result", "0");
			List<SmClientInfo> smClientInfos = smsManageService.list();
			modelMap.put("lists", smClientInfos);
			return PAGE_LIST;
		}
		modelMap.put("result", smsManageService.addClient(smClientInfo));
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);
		return PAGE_LIST;
	}

	@RequestMapping(value = "toAdd")
	public String toAdd() {
		return PAGE_ADD;
	}

	@RequestMapping(value = "qrylist")
	public String qryClient(ModelMap modelMap) {
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);

		return PAGE_LIST;

	}

	@RequestMapping(value = "delete")
	public String deleteClient(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		smsManageService.delete(id);
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);
		return PAGE_LIST;
	}
	
	@RequestMapping(value = "edit")
	public String editClient(HttpServletRequest request,SmClientInfo smClientInfo, ModelMap modelMap) {
		String id = request.getParameter("id");
		smClientInfo=smsManageService.findOne(id);
		modelMap.put("smClientInfo", smClientInfo);
		return PAGE_EDIT;
	}
	
	@RequestMapping(value = "update")
	public String updateClient(HttpServletRequest request,SmClientInfo smClientInfo, ModelMap modelMap) {
		smsManageService.update(smClientInfo);
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);
		return PAGE_LIST;
	}

}
