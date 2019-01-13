package com.sg.cp.controller.dropdownlist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.uspfservice.UspfService;
import commontools.CommonEnums;

@Controller
public class DropdownlistController {
	@Autowired private UspfService uspfservice;
	@RequestMapping(value="/dropdownlist/usgp/listleader",method=RequestMethod.GET)
	@ResponseBody
	public List<Uspf> getUspfList(Integer page,Integer rows){
		List<Uspf>  reList=new ArrayList<Uspf>();
		List<Uspf> list=uspfservice.getUspfList(CommonEnums.Status.A);
		for(Uspf u:list)
		{
			reList.add(u);
		}
		
		return reList;
	}
	
@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
