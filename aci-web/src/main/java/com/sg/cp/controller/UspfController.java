package com.sg.cp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.cp.pojo.Uscr;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.uspfservice.UspfService;
import commontools.CommonEnums;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Controller
public class UspfController {
	@Autowired private UspfService uspfservice;

	
	@RequestMapping(value="/uspf/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getUspfList(Integer page,Integer rows){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
		System.out.println("here easyui");
		return uspfservice.getUspfList(page, rows,CommonEnums.Status.A);
	}
	
	@RequestMapping(value="/uspfhist/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getUspfHistList(Integer page,Integer rows){
		return uspfservice.getUspfList(page, rows,CommonEnums.Status.C);
	}
	
	@RequestMapping(value="/uspfgrp/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getUspfGrpList(Integer page,Integer rows){
		return uspfservice.getUspfGrpList(page, rows,CommonEnums.Status.A);
	}
	
	@RequestMapping(value="/uspf/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateUspf(Uspf uspf){
		return uspfservice.updateUspf(uspf);
	}
	
	@RequestMapping(value="/uscr/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateUscr(Uscr uscr){
		return uspfservice.updateUscr(uscr);
	}
	
	@RequestMapping(value="/uspfgrp/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateUsgp(Usgp usgp){
		return uspfservice.updateUsgp(usgp);
	}
	
	@RequestMapping(value="/uspf/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUspf(Uspf uspf){
		//Uspf uspf = new Uspf();
		//BeanUtils.copyProperties(uspfParam, uspf);
		//System.out.println(uspfParam.toString());
		//uspf.setDob(CPDateUtils.ConvertStringToDate(uspfParam.getDob(), DateFormat.yyyyMMdd.name()));
		//uspf.setExpirydate(CPDateUtils.ConvertStringToDate(uspfParam.getExpirydate(), DateFormat.yyyyMMdd.name()));
		System.out.println("aop step 1 "+uspf.toString());
		return uspfservice.createUspf(uspf);
	}
	
	@RequestMapping(value="/uspfgrp/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUsgp(Usgp usgp){
		return uspfservice.createUsgp(usgp);
	}
	
	@RequestMapping(value="/uscr/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUscr(Uscr uscr){
		return uspfservice.createUscr(uscr);
	}
	
	@RequestMapping(value="/uspf/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteUspf(@PathVariable("id") String id){
		return uspfservice.deleteUspf(id);
	}
	
	@RequestMapping(value="/uscr/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteUscr(@PathVariable("id") String id){
		return uspfservice.deleteUscr(id);
	}
	
	@RequestMapping(value="/uspfgrp/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteUsgp(@PathVariable("id") String id){
		return uspfservice.deleteUsgp(id);
	}
	
	@RequestMapping(value="/uspf/search",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult searchUspf(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		if(request.getParameter("userid")!=null)
			map.put("userid", request.getParameter("userid"));
		if(request.getParameter("realname")!=null)
			map.put("realname", request.getParameter("realname"));
		
		return uspfservice.searchUspf(map, "com.sg.cp.pojo.Uspf");
	}
	
	@RequestMapping(value="/uscr/search",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult searchUscr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Uscr uscr = new Uscr();
		if(request.getParameter("userid")!=null)
		uscr.setUserid(request.getParameter("userid"));
		
		return uspfservice.searchUscr(uscr);
	}
	
	@RequestMapping(value="/uspfgrp/search",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult searchUsgp(Usgp usgp) throws Exception{
		return uspfservice.searchUsgp(usgp);
	}
	
	@RequestMapping(value="/uspfgrp/match",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult matchUsgp(@RequestBody List<Map<String,String>> list) throws Exception{
		/*
		System.out.println("list size "+list.size());
		for(Map<String, String> map:list)
		{
			System.out.println("map size "+map.size());
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println("key "+entry.getKey()+" value "+entry.getValue() );
			}
			
		}
		*/
		
		return uspfservice.matchUsgp(list);
	}

@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
