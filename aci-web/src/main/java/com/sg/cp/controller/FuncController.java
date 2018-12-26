package com.sg.cp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.cp.pojo.Fugp;
import com.sg.cp.pojo.Func;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.funcservice.FuncService;

import commontools.CommonEnums;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Controller
public class FuncController {
	@Autowired private FuncService funcService;

	@RequestMapping(value="/func/search",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult searchUspf(Func func) throws Exception{
		return funcService.searchFunc(func);
	}
	
	@RequestMapping(value="/func/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getFuncList(Integer page,Integer rows){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
		return funcService.getFuncList(page, rows,CommonEnums.Status.A);
	}

	@RequestMapping(value="/func/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateFunc(Func func){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
		return funcService.updateFunc(func);
	}
	
	@RequestMapping(value="/func/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteFunc(@PathVariable("id") String id){
		return funcService.deleteFunc(Integer.valueOf(id));
	}
	
	@RequestMapping(value="/func/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createFunc(Func func){
		return funcService.createFunc(func);
	}
	
	@RequestMapping(value="/fugp/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getFugpList(Integer page,Integer rows){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
		return funcService.getFugpList(page, rows,CommonEnums.Status.A);
	}
	
	@RequestMapping(value="/fugp/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateFugp(Fugp fugp){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
		return funcService.updateFugp(fugp);
	}
	
	@RequestMapping(value="/fugp/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteFugp(@PathVariable("id") String id){
		return funcService.deleteFugp(Integer.valueOf(id));
	}
	
	@RequestMapping(value="/fugp/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createFugp(Fugp fugp){
		return funcService.createFugp(fugp);
	}
	

	
@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
