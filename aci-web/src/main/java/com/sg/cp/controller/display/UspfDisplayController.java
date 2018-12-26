package com.sg.cp.controller.display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.uspfservice.UspfService;
import commontools.CommonEnums.Status;

@Controller
public class UspfDisplayController {
	@Autowired private UspfService uspfservice;

	
	@RequestMapping(value="/uspf/display/userlist",method=RequestMethod.GET)
	@ResponseBody
	public String[] getUspfList(){
		String [] stringArray=uspfservice.getUspfDisplayList(Status.A);
		return stringArray;
	}
	
	@RequestMapping(value="/uspf/display/usertable",method=RequestMethod.GET)
	@ResponseBody
	public String getUspfTable(){        
		
		List<Usgp> list=(List<Usgp>) uspfservice.getUsgpAndMatchingUsers().getData();
		
		List<Map> array = new LinkedList<Map>();
		
		Iterator<Usgp> usgpIterator = list.iterator();
		Integer noCounter=1;
		while(usgpIterator.hasNext())
		{
			Map map= new LinkedHashMap();
			
			Usgp currUsgp = usgpIterator.next();
			map.put("nub",currUsgp.getUsgpname());
			for(Uspf u : currUsgp.getUspfs())
			{
				map.put(noCounter, u.getUserid());
				noCounter++;
			}
			
			for(int i=noCounter;i<5;i++)
			{
				map.put(noCounter, "    ");
				noCounter++;
			}
			array.add(map);
			noCounter=1;
		}
		
		JSONArray json = new JSONArray(array);
	    System.out.printf( "HERE JSON: %s", json.toString());
	    
	    
		return json.toString();
	}

@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
