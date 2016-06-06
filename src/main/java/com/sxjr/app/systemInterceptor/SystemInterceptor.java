package com.sxjr.app.systemInterceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String returnUrl = "";
		String ticket="";
		Map<String, String[]> params = request.getParameterMap();
		for (String key : params.keySet()) {
			if ("ticket".equals(key)) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					ticket=value;
				}
			}
			
		}
		if (!"".equals(ticket)) {
			EmployeeVo employeeVo=employeeService.getEmployeeByTicket(ticket);
			request.getSession().setAttribute("loginUser", employeeVo);
			return true;
		}
		returnUrl=request.getRequestURL() + "?" + (request.getQueryString());
		Object obj = request.getSession().getAttribute("loginUser");
		if (obj == null) {
			// request.getRequestDispatcher("/login").forward(request,
			// response);
			response.sendRedirect("http://192.168.188.45:8080/sso/loginPage?returnUrl="+returnUrl);
			return false;
		} else {
			return super.preHandle(request, response, handler);
		}

		
	}

}