package com.sg.cp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.SearchService;
import com.sg.cp.service.uspfservice.UspfService;

import commontools.CommonEnums;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;
import solrtools.SearchResult;

@Controller
public class UspfController {
	@Autowired private UspfService uspfservice;

	
	@RequestMapping(value="/uspf/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getUspfList(Integer page,Integer rows){
		//1.引入服务
		//2.注入服务
		//3.调用服务的方法
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
	
	@RequestMapping(value="/uspfgrp/update",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult updateUsgp(Usgp usgp){
		return uspfservice.updateUsgp(usgp);
	}
	
	@RequestMapping(value="/uspf/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUspf(Uspf uspf){
		return uspfservice.createUspf(uspf);
	}
	
	@RequestMapping(value="/uspfgrp/create",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUsgp(Usgp usgp){
		return uspfservice.createUsgp(usgp);
	}
	
	@RequestMapping(value="/uspf/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteUspf(@PathVariable("id") String id){
		return uspfservice.deleteUspf(id);
	}
	
	@RequestMapping(value="/uspfgrp/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult deleteUsgp(@PathVariable("id") String id){
		return uspfservice.deleteUsgp(id);
	}
	
	@RequestMapping(value="/uspf/search",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult searchUspf(Uspf uspf) throws Exception{
		return uspfservice.searchUspf(uspf);
	}
	
	@RequestMapping(value="/uspfgrp/search",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult searchUsgp(Usgp usgp) throws Exception{
		return uspfservice.searchUsgp(usgp);
	}
	
	@RequestMapping(value="/uspfgrp/match",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult matchUsgp(@RequestBody List<Map<String,String>> list) throws Exception{
		return uspfservice.matchUsgp(list);
	}

@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
