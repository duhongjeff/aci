package com.sg.cp.controller.display;

import java.text.SimpleDateFormat;
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
		
		while(usgpIterator.hasNext())
		{
			Map map= new LinkedHashMap();
			
			Usgp currUsgp = usgpIterator.next();
			map.put("groupname",currUsgp.getUsgpname());
			
			int maxExpand=5;
			Integer noCounter=1;
			List<Uspf> uspfList=currUsgp.getUspfs();
			if(uspfList!=null && uspfList.size()>0)
			{
				maxExpand=uspfList.size()+5;
				for(Uspf u : currUsgp.getUspfs())
				{
					map.put(noCounter, u.getUserid());
					noCounter++;
				}
				expandCells(noCounter,maxExpand,map);

			}
			else
			{
				expandCells(noCounter,maxExpand,map);
			}

			array.add(map);
		}
		
		JSONArray json = new JSONArray(array);
	    System.out.printf( "HERE JSON: %s", json.toString());
	    
	    
		return json.toString();
	}
	
	public void expandCells(int noCounter,int maxExpand,Map map) {
		for(int i=noCounter;i<maxExpand;i++)
		{
			map.put(noCounter, " ");
			noCounter++;
		}
	}

@InitBinder  
public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
}
}
