package com.sg.cp.controller.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.sso.UserRegisterService;

import easyuitools.CommonResult;

@Controller
public class UserRegisterController {
	@Autowired
	private UserRegisterService registerservice;
	/**
	 * url：/user/check/{param}/{type}
	 * 
	 * @param param
	 * @param type  1  2 3 
	 * @return
	 */
	@RequestMapping(value="/user/check/{param}/{type}",method=RequestMethod.GET)
	@ResponseBody
	public CommonResult checkData(@PathVariable String param,@PathVariable Integer type){
		//1.引入服务
		//2.注入
		//3.调用
		return registerservice.checkData(param, type);
	}
	/*
	 * url:/user/register
	 *  参数：
	 *  username //用户名
		password //密码
		phone //手机号
		email //邮箱
	请求的方法：post
	返回值：json
	 */
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult register(Uspf user){
		
		System.out.println("USCR"+user.getUscr());
		System.out.println("USCR"+user.getUscr().getPassword());
		System.out.println("USPF"+user.toString());
		
		CommonResult result = registerservice.register(user);
		return result;
	}
}
