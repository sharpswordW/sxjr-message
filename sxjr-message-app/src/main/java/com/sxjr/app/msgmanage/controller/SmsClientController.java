package com.sxjr.app.msgmanage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxjr.app.model.SmClientInfo;
import com.sxjr.app.msgmanage.service.SmsManageService;
import com.sxjr.app.until.TicketUtil;
import com.sxjr.sso.vo.EmployeeVo;

/**
 * �������
 * 
 * @author outh
 * @Time 2016-06-06
 *
 */
@Controller
@RequestMapping(value = "app/sms")
public class SmsClientController {

	private static  Logger logger=LoggerFactory.getLogger(SmClientInfo.class);
	@Autowired
	private SmsManageService smsManageService;
	/**
	 * 增加客户端页面
	 */
	private String PAGE_ADD = "msgmanage/addClient";
	/**
	 * 客户端列表
	 */
	private String PAGE_LIST = "msgmanage/list";
	/**
	 *编辑客户端信息
	 */
	private String PAGE_EDIT = "msgmanage/edit";

	/**
	 * 保存客户端信息
	 *
	 * @param request smClientInfo
	 *            
	 * @return PAGE_LIST
	 * 
	 */
	@RequestMapping(value = "save")
	public String addClient(HttpServletRequest request,
			SmClientInfo smClientInfo, ModelMap modelMap) {
//		SmClientInfo clientInfo=smsManageService.selectbyName(smClientInfo.getName());
//		if (clientInfo != null) {
//			logger.error("smsClinet "+smClientInfo.getName()+" is already existed");
//			modelMap.put("result", "1");
//			List<SmClientInfo> smClientInfos = smsManageService.list();
//			modelMap.put("lists", smClientInfos);
//			return PAGE_LIST;
//		}
		smClientInfo.setAssessToken(TicketUtil.UUID());
		smClientInfo.setAssessSecret(TicketUtil.UUID());
		if (smClientInfo.getName() == null) {
			logger.error("smsclient name can not null");
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
	/**
	 * 增加客户端信息
	 *@param
	 *@return PAGE_ADD
	 * 
	 */
	@RequestMapping(value = "toAdd")
	public String toAdd() {
		return PAGE_ADD;
	}
	/**
	 * 获取客户端信息
	 *@param 
	 *@return PAGE_LIST
	 * 
	 */
	@RequestMapping(value = "qrylist")
	public String qryClient(ModelMap modelMap) {
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);

		return PAGE_LIST;

	}
	/**
	 * 删除客户端信息
	 *@param request
	 *@return PAGE_LIST
	 * 
	 */
	@RequestMapping(value = "delete")
	public String deleteClient(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		SmClientInfo smClientInfo=smsManageService.findOne(id);
		if (smClientInfo != null ) {
			smsManageService.delete(smClientInfo);
		}
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);
		return PAGE_LIST;
	}
	/**
	 * 编辑客户端信息
	 *@param request smClientInfo
	 *@return PAGE_EDIT
	 * 
	 */
	@RequestMapping(value = "edit")
	public String editClient(HttpServletRequest request,
			SmClientInfo smClientInfo, ModelMap modelMap) {
		String id = request.getParameter("id");
		smClientInfo = smsManageService.findOne(id);
		modelMap.put("smClientInfo", smClientInfo);
		return PAGE_EDIT;
	}

	/**
	 * 更新客户端信息
	 *@param request smClientInfo
	 *@return PAGE_LIST
	 * 
	 */
	@RequestMapping(value = "update")
	public String updateClient(HttpServletRequest request,
			SmClientInfo smClientInfo, ModelMap modelMap) {
		smsManageService.update(smClientInfo);
		List<SmClientInfo> smClientInfos = smsManageService.list();
		modelMap.put("lists", smClientInfos);
		return PAGE_LIST;
	}
	/**
	 * 更新客户端状态
	 *@param request smClientInfo
	 *@return PAGE_LIST
	 * 
	 */
	@RequestMapping(value = "disable")
	public String disable(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		SmClientInfo smClientInfo = smsManageService.findOne(id);
		if (smClientInfo.isState()) {
			smClientInfo.setState(false);
		} else {
			smClientInfo.setState(true);
		}
		smsManageService.update(smClientInfo);
		List list = smsManageService.list();
		modelMap.put("lists", list);
		return PAGE_LIST;
	}
}
