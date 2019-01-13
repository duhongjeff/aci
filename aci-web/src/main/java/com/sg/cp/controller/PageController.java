package com.sg.cp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	//显示商品的查询的页面
	//  url:/item-list
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/nav/{page}")
	public String displayLeftMenu(@PathVariable String page){
		System.out.print(page);
		return "nav/"+page;
	}
	
	@RequestMapping("/uspf/{type}/{target}")
	public String displayUspfMain(@PathVariable String type,@PathVariable String target,String redirect,Model model){
		model.addAttribute("redirect", redirect);
		return "uspf/"+type+"/"+target;
	}
	
	@RequestMapping("/func/{type}/{target}")
	public String displayFuncMain(@PathVariable String type,@PathVariable String target){
		return "func/"+type+"/"+target;
	}
	
	@RequestMapping("/fugp/{type}/{target}")
	public String displayFugpMain(@PathVariable String type,@PathVariable String target){
		return "fugp/"+type+"/"+target;
	}
	
	@RequestMapping("/setting/{target}")
	public String displaySettingMain(@PathVariable String target){
		return "setting/"+target;
	}
	
	@RequestMapping("/sso/{target}")
	public String displaySSOMain(@PathVariable String target,String redirect,Model model){
		System.out.println(redirect);
		model.addAttribute("redirect", redirect);
		return "sso/"+target;
	}
}
