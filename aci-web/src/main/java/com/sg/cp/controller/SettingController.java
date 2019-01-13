package com.sg.cp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.sg.cp.model.UspfEnh;
import com.sg.cp.pojo.Drev;
import com.sg.cp.pojo.Func;
import com.sg.cp.pojo.Item;
import com.sg.cp.service.funcservice.FuncService;
import com.sg.cp.service.setting.SettingService;
import com.sg.cp.service.uspfservice.UspfService;

import commontools.CPDateUtils;
import commontools.CommonEnums;
import commontools.CommonEnums.DateFormat;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Controller
public class SettingController {
	@Autowired
	private UspfService uspfservice;
	@Autowired
	private FuncService funcservice;
	@Autowired
	private SettingService settingService;
	
	public static HttpSolrClient getSolrClient() {
		final String BASE_URL = "http://192.168.1.110:9080/solr/new_core/";
		return new HttpSolrClient.Builder(BASE_URL).withConnectionTimeout(10000).withSocketTimeout(60000).build();
	}

	@RequestMapping(value = "/setting/uspfsolr", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult sycnUspfSolr(Integer page, Integer rows) {
		// 1.引入服务
		// 2.注入服务
		// 3.调用服务的方法

		EasyUIDataGridResult result = uspfservice.getUspfList(page, rows, CommonEnums.Status.A);
		List<UspfEnh> list = result.getRows();
		HttpSolrClient solrServer = getSolrClient();

		try {
			for (UspfEnh u : list) {
				// 3.向文档中添加域
				SolrInputDocument document = new SolrInputDocument();
				document.addField("userid", u.getUserid());
				document.addField("realname", u.getRealname());
				document.addField("reporterid", u.getReporterid());
				document.addField("gender", u.getGender());
				document.addField("email", u.getEmail());
				document.addField("telno", u.getTelno());
				document.addField("wechatno", u.getWechatno());
				document.addField("addr", u.getAddr());
				document.addField("dob", u.getDob());
				document.addField("expriydate", u.getExpirydate());
				document.addField("designation", u.getDesignation());
				document.addField("status", u.getStatus());
				solrServer.add(document);
				solrServer.commit();
			}
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CommonResult.ok();
	}
	
	@RequestMapping(value = "/setting/funcsolr", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult sycnFuncSolr(Integer page, Integer rows) {
		// 1.引入服务
		// 2.注入服务
		// 3.调用服务的方法

		EasyUIDataGridResult result = funcservice.getFuncList(page, rows, CommonEnums.Status.A);
		List<Func> list = result.getRows();
		HttpSolrClient solrServer = getSolrClient();

		try {
			for (Func u : list) {
				// 3.向文档中添加域
				SolrInputDocument document = new SolrInputDocument();
				document.addField("functionid", u.getFunctionid());
				document.addField("functionname", u.getFunctionname());
				solrServer.add(document);
				solrServer.commit();
			}
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}

		return CommonResult.ok();
	}
	
	@RequestMapping(value = "/setting/setweekends", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult setweekends() {
		
		settingService.setWeekends("2019");

		return CommonResult.ok();
	}
	
	@RequestMapping("/setting/addExcel")
	@ResponseBody
	public CommonResult addExcel(HttpServletRequest request) 
	{
		String msg="";	
		try
		{			 	      
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		    //输入流  
		    InputStream in =null;
		    MultipartFile file = multipartRequest.getFile("upfile"); 
		    if(file.isEmpty())
		    {  
		    	msg="文件不存在！";
		    	return CommonResult.build(400, "File not exist");
		    }
		    String filename=file.getOriginalFilename();
		    in = file.getInputStream(); 
		    //得到excel  
		    Workbook wb = null;
		    String fileType = filename.substring(filename.lastIndexOf("."));  
		    if((".xlsx").equals(fileType))
		    {  
		       wb = new XSSFWorkbook(in);  //2007+  
		    }else
		    {  
		    	msg="文件格式错误！";
				return CommonResult.build(400, "Invalid form");
		    }   		  
		    //得到sheet  
		    Sheet sheet = wb.getSheetAt(0); //默认取第一个sheet 	         
		    //int colsNum = sheet.getPhysicalNumberOfRows();  //获取实际的行数	       
		    int rowsNum = sheet.getLastRowNum();// 
		    System.out.println("last row is: "+rowsNum);
		    List<Drev> lDrev = new ArrayList<Drev>();
		    Drev drev;
		    for(int j=2; j<=rowsNum;j++) //第一行为表头，所以从第二行开始
		    {// getLastRowNum，获取最后一行的行标
		        Row row =sheet.getRow(j);
		        if (row != null) 
		        {
		        	drev=new Drev(); 
		        	System.out.println("----begin----");
		        	
		        	if(row.getCell(0)==null || StringUtils.isBlank(row.getCell(0).toString()))
		        	{
		        		// primary field
		        		continue;
		        	}
		        	else
		        	{
		        		System.out.println(row.getCell(0).toString());
		        		Date transDate=CPDateUtils.ConvertStringToDate(row.getCell(0).toString(), DateFormat.yyyyMMdd.name());
			        	drev.setTransdate(transDate);
		        	}
		        	
		        	
		     
		        	System.out.println(row.getCell(1)==null?"null":row.getCell(1).toString()); 
		        	
		        	if(row.getCell(2)==null || StringUtils.isBlank(row.getCell(2).toString()))
		        	{
		        		// primary field
		        		continue;
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(2).toString()); 
			        	Item item=settingService.getItemByName(row.getCell(1).toString(),row.getCell(2).toString());
			        	if(item==null)
			        	return CommonResult.build(400, "item not configured for: "+row.getCell(2).toString());
			        	drev.setItemid(item.getItemid());
		        	}

		        	System.out.println(row.getCell(3)==null?"null":row.getCell(3).toString());
		        	
		        	
		        	
		        	if(row.getCell(4)==null || StringUtils.isBlank(row.getCell(4).toString()))
		        	{
		        		// primary field
		        		return CommonResult.build(400, "row for amount is blank at row: "+j);
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(4).toString());
			        	drev.setTotalamt(new BigDecimal(row.getCell(4).toString()));
		        	}
		        	

		        	if(row.getCell(5)==null || StringUtils.isBlank(row.getCell(5).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
		        		System.out.println(row.getCell(5).toString());
			        	drev.setDailyrev(new BigDecimal(row.getCell(5).toString()));
		        	}

		        	
		        	if(row.getCell(6)==null || StringUtils.isBlank(row.getCell(6).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(6).toString());
			        	drev.setMonthlyrev(new BigDecimal(row.getCell(6).toString()));
		        	}
		        	

		        	if(row.getCell(7)==null || StringUtils.isBlank(row.getCell(7).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(7).toString());
			        	drev.setMonthcutoff(Math.round(Float.parseFloat(row.getCell(7).toString())));
		        	}
		        	

		        	if(row.getCell(8)==null || StringUtils.isBlank(row.getCell(8).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(8).toString());
			        	drev.setPrdrev(new BigDecimal(row.getCell(8).toString()));
		        	}

		        	if(row.getCell(9)==null || StringUtils.isBlank(row.getCell(9).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(9).toString());
			        	Date prdFromDate=CPDateUtils.ConvertStringToDate(row.getCell(9).toString(), DateFormat.yyyyMMdd.name());
			        	drev.setPrdstart(prdFromDate);
		        	}

		        	if(row.getCell(10)==null || StringUtils.isBlank(row.getCell(10).toString()))
		        	{
			        	//nothing here
		        	}
		        	else
		        	{
			        	System.out.println(row.getCell(10).toString());
			        	Date prdToDate=CPDateUtils.ConvertStringToDate(row.getCell(10).toString(), DateFormat.yyyyMMdd.name());
			        	drev.setPrdend(prdToDate);
		        	}

		        	System.out.println("row number is:" +j);
		        	System.out.println("----end----");
		        	lDrev.add(drev);
		        }
		              
		    }
		    wb.close();	  
		    if(!lDrev.isEmpty())
		    	return settingService.setDrev(lDrev);
		 } catch (IOException e) 
	     {  
		      e.printStackTrace();  
		 }
		//获取登陆用户的id
		return CommonResult.build(400, "update fail, please check log");
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
