package com.sg.cp.controller.sso;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.sg.cp.service.sso.UserLoginService;

import commontools.CookieUtils;
import commontools.JsonUtils;
import easyuitools.CommonResult;

@Controller
public class UserLoginController {
	@Autowired
	private UserLoginService loginservice;
	@Value("${SSO_URL}")
	private String SSO_URL;
	
	/**
	 * url:/user/login
	 * 参数：username password
	 * 返回值：json
	 * 请求限定的方法：post
	 */
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult login(HttpServletRequest request,HttpServletResponse response,String username,String password){
		//1.引入服务
		//2.注入服务
		//3.调用服务
		CommonResult result = loginservice.login(username, password);
		//4.需要设置token到cookie中 可以使用 工具类  cookie需要跨域
		if(result.getStatus()==200){
			CookieUtils.setCookie(request, response,"TT_TOKEN", result.getData().toString());
			CookieUtils.setCookie(request, response,"CURR_USER", username);
		}
		return result;
	}
	
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	@ResponseBody
	public CommonResult logout(HttpServletRequest request,HttpServletResponse response,String username,String password){
		//System.out.println("here get the value: " + CookieUtils.getCookieValue(request, "TT_TOKEN")); 
		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		CookieUtils.deleteCookie(request, response, "CURR_USER");
		CommonResult result = loginservice.logout(CookieUtils.getCookieValue(request, "TT_TOKEN"));
		try {
			response.sendRedirect(SSO_URL+"/sso/login?redirect="+request.getRequestURL().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * url:/user/token/{token}
	 * 参数：token
	 * 返回值：json 
	 * 请求限定的方法：get
	 */
	@RequestMapping(value="/user/token/{token}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getUserByToken(@PathVariable String token,String callback){
		
		//判断是否是Jsonp请求
		if(StringUtils.isNotBlank(callback)){
			//如果是jsonp 需要拼接 类似于fun({id:1});
			CommonResult result = loginservice.getUserByToken(token);
			String jsonpstr = callback+"("+JsonUtils.objectToJson(result)+")";
			return jsonpstr;
		}
		//如果不是jsonp
		//1.调用服务
		CommonResult result = loginservice.getUserByToken(token);
		return JsonUtils.objectToJson(result);
	}
}
