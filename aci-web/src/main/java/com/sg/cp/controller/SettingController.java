package com.sg.cp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.sg.cp.model.UspfEnh;
import com.sg.cp.pojo.Func;
import com.sg.cp.service.funcservice.FuncService;
import com.sg.cp.service.uspfservice.UspfService;

import commontools.CommonEnums;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Controller
public class SettingController {
	@Autowired
	private UspfService uspfservice;
	@Autowired
	private FuncService funcservice;

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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
