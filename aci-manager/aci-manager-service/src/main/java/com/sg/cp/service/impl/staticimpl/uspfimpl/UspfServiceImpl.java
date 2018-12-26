package com.sg.cp.service.impl.staticimpl.uspfimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.cp.mapper.UsgpMapper;
import com.sg.cp.mapper.UspfGpMapper;
import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.model.UsgpEnh;
import com.sg.cp.model.UspfEnh;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.UsgpExample;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.pojo.UspfExample;
import com.sg.cp.pojo.UspfGp;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.SearchService;
import com.sg.cp.service.impl.staticimpl.StaticGeneralService;
import com.sg.cp.service.temporaryservice.TmpSolutionService;
import com.sg.cp.service.uspfservice.UspfService;

import commontools.CPDateUtils;
import commontools.CommonEnums;
import commontools.CommonEnums.Status;
import commontools.JsonArray;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Service
public class UspfServiceImpl extends StaticGeneralService implements UspfService {

	@Autowired
	private UspfMapper uspfmapper;
	@Autowired
	private UsgpMapper usgpmapper;
	@Autowired
	private UspfGpMapper uspfGpMapper;
	@Autowired
	private SearchService searchservice;
	@Autowired
	private TmpSolutionService tmpSolutionService;

	@Autowired
	private JedisClient jedisClient;

	@Value("${USERLIST_KEY}") private String USERLISTKEY;
	@Value("${USERGRPLIST_KEY}") private String USERGRPLIST_KEY;
	@Value("${LIST_KEY}") private String LIST;
	@Value("${SEARCH_LIST_KEY}") private String SEARCHLIST;

	@Resource(name = "topicDestination")
	private Destination destination;

	//TODO 不应该在这里做分页
	
	@Override
	public String[] getUspfDisplayList(Status status) {
		List<Uspf> list=super.daoGetUspfList(status);
		String [] target = new String[list.size()];
		int index =0;
		for(Uspf u :list)
		{
			target[index]=u.getUserid();
			index++;
		}
		return target;
	}
	
	
	@Override
	public EasyUIDataGridResult getUspfList(Integer page, Integer rows, Status status) {

		List<UspfEnh> targetlist = new ArrayList<UspfEnh>();
		targetlist = tmpSolutionService.tmpSearchFunctionSolution(new ArrayList());

		if (targetlist == null || targetlist.size() == 0) {

			List<Uspf> list = new ArrayList<Uspf>();
			// list=jedisClient.queryList(LIST, USERLISTKEY);

			// 1.设置分页的信息 使用pagehelper
			if (page == null)
				page = 1;
			if (rows == null)
				rows = 30;
			PageHelper.startPage(page, rows);

			// 4.根据mapper调用查询所有数据的方法
			list = daoSelectUspfwithUsgp(status);

			UspfEnh enh;
			for (Uspf p : list) {
				enh = new UspfEnh();
				enh.setUserid(p.getUserid());
				enh.setRealname(p.getRealname());
				enh.setReporterid(p.getReporterid());
				enh.setGender(p.getGender());
				enh.setTelno(p.getTelno());
				enh.setAddr(p.getAddr());
				enh.setDob(p.getDob());
				enh.setExpirydate(p.getExpirydate());
				enh.setDesignation(p.getDesignation());
				enh.setStatus(p.getStatus());
				enh.setRemark(p.getRemark());
				
				String usgpDesc="";
				List<Usgp> usgpList=p.getUsgps();
				for(Usgp u : usgpList)
				{
					usgpDesc+=u.getUsgpname();
				}
				enh.setUsergroupdesc(usgpDesc);
				
				targetlist.add(enh);
			}
		}

		// 5.获取分页的信息
		PageInfo<UspfEnh> info = new PageInfo<>(targetlist);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		// 7.返回

		// 向缓存中添加数据
		// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
		return result;
	}

	@Override
	public EasyUIDataGridResult getUspfGrpList(Integer page, Integer rows, Status status) {
		List<UsgpEnh> targetlist = new ArrayList<UsgpEnh>();
		targetlist = tmpSolutionService.tmpSearchFunctionSolutionForUsgp(new ArrayList());

		if (targetlist == null || targetlist.size() == 0) {

			List<Usgp> list = new ArrayList<Usgp>();
			// list=jedisClient.queryList(LIST, USERLISTKEY);

			// 1.设置分页的信息 使用pagehelper
			if (page == null)
				page = 1;
			if (rows == null)
				rows = 30;
			PageHelper.startPage(page, rows);


			// 4.根据mapper调用查询所有数据的方法
			list =super.daoGetUsgpList(status);

			// Here to be optimized

			UsgpEnh enh;
			for (Usgp p : list) {
				enh = new UsgpEnh();
				enh.setUsgpid(p.getUsgpid());
				enh.setUsgpiddesc(p.getUsgpid().toString());
				enh.setUsgpname(p.getUsgpname());
				enh.setStatus(p.getStatus());
				enh.setLeaderid(p.getLeaderid());
				enh.setRemark(p.getRemark());
				
				
				targetlist.add(enh);
			}
		}

		// 5.获取分页的信息
		PageInfo<UsgpEnh> info = new PageInfo<>(targetlist);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		// 7.返回

		// 向缓存中添加数据
		// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
		return result;
	}

	@Override
	public CommonResult updateUspf(Uspf uspf) {

		// 2.补全其他的属性
		uspf.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		uspf.setStatus("A");
		
		String errormsg=super.daoUpdateUspf(uspf);
		jedisClient.hdel(LIST, USERLISTKEY);
		return CommonResult.ok();
	}
	
	@Override
	public CommonResult updateUsgp(Usgp usgp) {

		// 1.注入example
		UsgpExample example = new UsgpExample();
		com.sg.cp.pojo.UsgpExample.Criteria criteria = example.createCriteria();
		criteria.andUsgpidEqualTo(usgp.getUsgpid());

		// 2.补全其他的属性
		usgp.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		usgp.setStatus("A");
		// 3.插入内容表中
		super.daoUpdateUsgp(usgp);
		jedisClient.hdel(LIST, USERGRPLIST_KEY);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createUspf(Uspf uspf) {

		// 2.补全其他的属性
		uspf.setCredate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		uspf.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));

		// 3.插入内容表中
		String msg=super.daoCreateUspf(uspf);
		return CommonResult.ok();
	}
	
	@Override
	public CommonResult createUsgp(Usgp usgp) {

		// 2.补全其他的属性
		usgp.setCredate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		usgp.setCreby("duhong");
		usgp.setLupdate(CPDateUtils.convertDateToInt(new Date(), CommonEnums.DateFormat.yyyyMMdd));
		usgp.setLupby("duhong");
		
		// 3.插入内容表中
		String msg=super.daoCreateUsgp(usgp);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteUspf(String userid) {
		String msg=null;
		msg=super.daoDeleteUspfById(userid);
		return CommonResult.ok();
	}
	
	@Override
	public CommonResult deleteUsgp(String usgpid) {

		String msg=null;
		msg=super.daoDeleteUsgpById(Integer.valueOf(usgpid));

		return CommonResult.ok();
	}


	@Override
	public EasyUIDataGridResult searchUspf(Uspf uspf) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", uspf.getUserid());

		List<Uspf> uspflist = new ArrayList<Uspf>();

		SolrDocumentList searchList = searchservice.searchSolrDocumentList(map);

		for (SolrDocument solrDocument : searchList) {
			Uspf item = new Uspf();
			item.setUserid(solrDocument.get("userid").toString());
			item.setRealname(solrDocument.get("realname").toString());
			item.setReporterid(solrDocument.get("reporterid").toString());
			item.setGender(solrDocument.get("gender").toString());
			item.setEmail(solrDocument.get("email").toString());
			item.setTelno(solrDocument.get("telno").toString());
			item.setWechatno(solrDocument.get("wechatno").toString());
			item.setAddr(solrDocument.get("addr").toString());
			item.setDesignation(solrDocument.get("designation").toString());
			item.setStatus(solrDocument.get("status").toString());

			uspflist.add(item);
		}
		EasyUIDataGridResult result = new EasyUIDataGridResult();

		if (uspflist.size() > 0) {
			PageInfo<Uspf> info = new PageInfo<>(uspflist);
			result.setTotal((int) info.getTotal());
			result.setRows(info.getList());
			jedisClient.addToList(LIST, SEARCHLIST, uspflist);
		}

		return result;
	}
	
	@Override
	public EasyUIDataGridResult searchUsgp(Usgp usgp) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("usgpname", usgp.getUsgpname());

		List<Usgp> usgpList = new ArrayList<Usgp>();

		SolrDocumentList searchList = searchservice.searchSolrDocumentList(map);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		
		if(searchList==null)
			return result;
		
		for (SolrDocument solrDocument : searchList) {
			Usgp item = new Usgp();
			item.setUsgpname(solrDocument.get("usgpname").toString());

			usgpList.add(item);
		}
		

		if (usgpList.size() > 0) {
			PageInfo<Usgp> info = new PageInfo<>(usgpList);
			result.setTotal((int) info.getTotal());
			result.setRows(info.getList());
			jedisClient.addToList(LIST, SEARCHLIST, usgpList);
		}

		return result;
	}


	@Override
	public CommonResult getUsgpAndMatchingUsers() {
		List<Usgp> list=usgpmapper.selectusgpandmatchingusers(Status.A.name());

	    
	    CommonResult commonResult = new CommonResult(list);
		
		return commonResult;
	}


	@Override
	public CommonResult matchUsgp(List<Map<String,String>> list) {
		
		
		
		for(Map<String,String> m :list)
		{
			Usgp usgp=new Usgp();
			UsgpExample example = new UsgpExample();
			com.sg.cp.pojo.UsgpExample.Criteria criteria = example.createCriteria();
			int usgpId=0;
			for (Map.Entry<String, String> entry : m.entrySet())
			{
				
				if(entry.getKey().trim().equalsIgnoreCase("nub"))
				{
					criteria.andUsgpnameEqualTo(entry.getValue());
					usgpId=usgpmapper.selectByExample(example).get(0).getUsgpid();
				}
				else
				{
					if(usgp!=null && !entry.getValue().trim().isEmpty())
					{
						System.out.println(entry.getKey()+" -->"+entry.getValue());
						UspfGp ug = new UspfGp();
						ug.setUsgpid(usgpId);
						ug.setUserid(entry.getValue());
						uspfGpMapper.insert(ug);
					}
				}
			}
			//usgp.setUspfs(listUspf);
			
		}
		
		
		return CommonResult.ok();
	}

}
