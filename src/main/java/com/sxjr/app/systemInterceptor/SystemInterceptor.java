package com.sxjr.app.systemInterceptor;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sxjr.app.common.ParseProperties;
import com.sxjr.sso.service.IEmployeeService;
import com.sxjr.sso.vo.EmployeeVo;

/**
 * 
 * @author outh
 * @date 2016-06-03
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	IEmployeeService employeeService;
	@Autowired
	ParseProperties parseProperties;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String returnUrl = "";
		String ticket = request.getParameter("ticket");
		String ssoUrl=parseProperties.getValue("ssoLoginUrl");
		if (ticket != null) {
			EmployeeVo employeeVo = employeeService.getEmployeeByTicket(ticket);
			request.getSession().setAttribute("loginUser", employeeVo);
			return true;
		}
		returnUrl = request.getRequestURL() + "?" + (request.getQueryString());
		Object obj = request.getSession().getAttribute("loginUser");
		if (obj == null) {
			response.sendRedirect(ssoUrl+ returnUrl);
			return false;
		} else {
			return super.preHandle(request, response, handler);
		}

	}
	public String  getProperties() {
		InputStream ins=SystemInterceptor.class.getResourceAsStream("../config/config.properties");  
        // 生成properties对象  
        Properties p = new Properties();  
        try {  
            p.load(ins);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 输出properties文件的内容  
        System.out.println("name:" + p.getProperty("name"));  
        System.out.println("password:" + p.getProperty("password")); 
		
		return null;
		
	}

}