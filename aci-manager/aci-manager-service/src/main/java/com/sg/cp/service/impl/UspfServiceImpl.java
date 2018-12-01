package com.sg.cp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.cp.mapper.UsgpMapper;
import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.UsgpExample;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.pojo.UspfExample;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.UspfService;

import commontools.CPDateUtils;
import commontools.CommonEnums;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Service
public class UspfServiceImpl implements UspfService{

	@Autowired private UspfMapper uspfmapper;
	@Autowired private UsgpMapper usgpmapper;
	
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${USERLIST_KEY}") private String USERLISTKEY;
	@Value("${USERGRPLIST_KEY}") private String USERGRPLIST_KEY;
	@Value("${LIST_KEY}") private String LIST;
	
	
	@Override
	public EasyUIDataGridResult getUspfList(Integer page, Integer rows, String status) {
		List<Uspf> list=new ArrayList<Uspf>();
		list=jedisClient.queryList(LIST, USERLISTKEY);
		
		//1.设置分页的信息 使用pagehelper
		if(page==null)page=1;
		if(rows==null)rows=30;
		PageHelper.startPage(page, rows);
		//2.注入mapper
		//3.创建example 对象 不需要设置查询条件
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria usfpCriteria=example.createCriteria();
		usfpCriteria.andStatusEqualTo(status);
		
		//4.根据mapper调用查询所有数据的方法
		list = uspfmapper.selectByExample(example);
		//5.获取分页的信息
		PageInfo<Uspf> info = new PageInfo<>(list);
		//6.封装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)info.getTotal());
		result.setRows(info.getList());
		//7.返回
		
		//向缓存中添加数据
		jedisClient.addToList(LIST, USERLISTKEY, list);
		return result;
	}
	
	@Override
	public EasyUIDataGridResult getUspfGrpList(Integer page, Integer rows) {
		List<Usgp> list=new ArrayList<Usgp>();
		list=jedisClient.queryList(LIST, USERGRPLIST_KEY);
		
		//1.设置分页的信息 使用pagehelper
		if(page==null)page=1;
		if(rows==null)rows=30;
		PageHelper.startPage(page, rows);
		//2.注入mapper
		//3.创建example 对象 不需要设置查询条件
		UsgpExample example = new UsgpExample();
		com.sg.cp.pojo.UsgpExample.Criteria  usgpCriteria=example.createCriteria();
		
		//4.根据mapper调用查询所有数据的方法
		list = usgpmapper.selectByExample(example);
		//5.获取分页的信息
		PageInfo<Usgp> info = new PageInfo<>(list);
		//6.封装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)info.getTotal());
		result.setRows(info.getList());
		//7.返回
		//向缓存中添加数据
		jedisClient.addToList(LIST, USERGRPLIST_KEY, list);
		return result;
	}

	@Override
	public CommonResult updateUspf(Uspf uspf) {
		
		//1.注入example
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uspf.getUserid());
		
		//2.补全其他的属性
		uspf.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		uspf.setStatus("A");
		//3.插入内容表中
		uspfmapper.updateByExampleSelective(uspf,example);
		return CommonResult.ok();
	}
	
	@Override
	public CommonResult createUspf(Uspf uspf) {
		
		//2.补全其他的属性
		uspf.setCredate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		uspf.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		//3.插入内容表中
		uspfmapper.insertSelective(uspf);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteUspf(String userid) {
			UspfExample example = new UspfExample();
			com.sg.cp.pojo.UspfExample.Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userid);
			uspfmapper.deleteByExample(example);
			
		return CommonResult.ok();
	}



}
