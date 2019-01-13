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
import org.springframework.util.DigestUtils;

import com.alibaba.dubbo.common.json.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.cp.mapper.UsgpMapper;
import com.sg.cp.mapper.UspfGpMapper;
import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.model.UsgpEnh;
import com.sg.cp.model.UspfEnh;
import com.sg.cp.pojo.Uscr;
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

	@Value("${USERLIST_KEY}")
	private String USERLISTKEY;
	@Value("${USERGRPLIST_KEY}")
	private String USERGRPLIST_KEY;
	@Value("${LIST_KEY}")
	private String LIST;
	@Value("${SEARCH_LIST_KEY}")
	private String SEARCHLIST;

	@Resource(name = "topicDestination")
	private Destination destination;

	// TODO 不应该在这里做分页

	@Override
	public String[] getUspfDisplayList(Status status) {
		List<Uspf> list = super.daoGetUspfList(status);
		String[] target = new String[list.size()];
		int index = 0;
		for (Uspf u : list) {
			target[index] = u.getUserid();
			index++;
		}
		return target;
	}
	
	@Override
	public List<Uspf> getUspfList(Status status) {
		return super.daoGetUspfList(status);
	}

	@Override
	public EasyUIDataGridResult getUspfList(Integer page, Integer rows, Status status) {

		/* Step0: Temporary method for searching (Search --> put redis --> back to jsp
        --> jsp reload --> here to search in redis)*/
		
		List<Uspf> targetlist = tmpSolutionService.tmpSearchFunctionSolution(new ArrayList());

		List<Uspf> list = new ArrayList<Uspf>();
		if (targetlist == null || targetlist.size() == 0) {
			 /*Step1: Search in Redis list=jedisClient.queryList(LIST, USERLISTKEY);*/

			//Step2: Set pagination by using Pagehelper
			if (page == null)
				page = 1;
			if (rows == null)
				rows = 30;
			PageHelper.startPage(page, rows);

			//Step3: Get uspf list with usgp list 
			list = daoSelectUspfwithUsgp(status);
			for(Uspf uspf:list)
			{
				String usgpDesc="";
				List<Usgp> usgpList=uspf.getUsgps();
				for(Usgp usgp:usgpList)
				{
					usgpDesc=usgpDesc+usgp.getUsgpname()+" ";
				}
				uspf.setUsgpDesc(usgpDesc);
				System.out.print(uspf);
			}
		}
		
		//Step4: Pagination Implementation
		PageInfo<Uspf> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());

		// Put data in redis
		// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
		return result;
	}

	@Override
	public EasyUIDataGridResult getUspfGrpList(Integer page, Integer rows, Status status) {
		
		/* Step0: Temporary method for searching (Search --> put redis --> back to jsp
        --> jsp reload --> here to search in redis)*/
		 List<Usgp> targetlist = tmpSolutionService.tmpSearchFunctionSolutionForUsgp(new ArrayList());
		 List<Usgp> list = new ArrayList<Usgp>();
		if (targetlist == null || targetlist.size() == 0) {
			
			 /*Step1: list=jedisClient.queryList(LIST, USERLISTKEY);*/

			//Step2: Set pagination by using Pagehelper
			if (page == null)
				page = 1;
			if (rows == null)
				rows = 30;
			PageHelper.startPage(page, rows);

			//Step3: Get usgp list 
			list = super.daoGetUsgpList(status);
		}

		//Step4: Pagination Implementation
		PageInfo<Usgp> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		// 7.返回

		// Put data in redis
		// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
		return result;
	}

	@Override
	public CommonResult updateUspf(Uspf uspf) {
		//TODO lup to be optimized
		super.daoUpdateUspf(uspf);
		jedisClient.hdel(LIST, USERLISTKEY);
		return CommonResult.ok();
	}

	@Override
	public CommonResult updateUsgp(Usgp usgp) {
		//TODO lup to be optimized
		usgp.setLupdate(new Date());
		super.daoUpdateUsgp(usgp);
		jedisClient.hdel(LIST, USERGRPLIST_KEY);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createUspf(Uspf uspf) {
		super.daoCreateUspf(uspf);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createUsgp(Usgp usgp) {
		super.daoCreateUsgp(usgp);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteUspf(String userid) {
	    String msg=super.daoDeleteUspfById(userid);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteUsgp(String usgpid) {
		String msg=super.daoDeleteUsgpById(Integer.valueOf(usgpid));
		return CommonResult.ok();
	}

	@Override
	public EasyUIDataGridResult searchUspf(Map<String, String> map, String className) throws Exception {

		Uspf u = new Uspf();
		for (Map.Entry<String, String> entry : map.entrySet()) { 
		  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		  if(entry.getKey().equalsIgnoreCase("userid"))
			  u.setUserid(entry.getValue().toString());
		  if(entry.getKey().equalsIgnoreCase("realname"))
			  u.setRealname(entry.getValue().toString());
		}
		
		List<Uspf> list = super.daoSearchUspf(u);
		for(Uspf uspf:list)
		{
			String usgpDesc="";
			List<Usgp> usgpList=uspf.getUsgps();
			for(Usgp usgp:usgpList)
			{
				usgpDesc=usgpDesc+usgp.getUsgpname()+" ";
			}
			uspf.setUsgpDesc(usgpDesc);
			System.out.print(uspf);
		}
	
		//Step4: Pagination Implementation
		PageInfo<Uspf> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());

		/*
		List<Uspf> uspflist = new ArrayList<Uspf>();
		SolrDocumentList searchList = searchservice.generalPojoSearch(map, className);

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
		*/

		return result;
	}

	@Override
	public EasyUIDataGridResult searchUsgp(Usgp usgp) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("usgpname", usgp.getUsgpname());

		List<Usgp> usgpList = new ArrayList<Usgp>();

		SolrDocumentList searchList = searchservice.generalPojoSearch(map, null);
		EasyUIDataGridResult result = new EasyUIDataGridResult();

		if (searchList == null)
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
		List<Usgp> list = usgpmapper.selectusgpandmatchingusers(Status.A.name());

		CommonResult commonResult = new CommonResult(list);

		return commonResult;
	}

	@Override
	public CommonResult matchUsgp(List<Map<String, String>> list) {
		super.daoDeleteAllUspfGp();
		for (Map<String, String> m : list) {
			Usgp usgp = new Usgp();
			UsgpExample example = new UsgpExample();
			com.sg.cp.pojo.UsgpExample.Criteria criteria = example.createCriteria();
			int usgpId = 0;
			for (Map.Entry<String, String> entry : m.entrySet()) {

				if (entry.getKey().trim().equalsIgnoreCase("groupname")) {
					criteria.andUsgpnameEqualTo(entry.getValue());
					usgpId = usgpmapper.selectByExample(example).get(0).getUsgpid();
				} else {
					if (usgp != null && !entry.getValue().trim().isEmpty()) {
						UspfGp ug = new UspfGp();
						ug.setUsgpid(usgpId);
						ug.setUserid(entry.getValue());
						super.daoCreateUspfgp(ug);
					}
				}
			}
			// usgp.setUspfs(listUspf);

		}

		return CommonResult.ok();
	}

	@Override
	public CommonResult updateUscr(Uscr uscr) {
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(uscr.getPassword().getBytes());
		uscr.setPassword(md5DigestAsHex);
		super.daoUpdateUscr(uscr);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createUscr(Uscr uscr) {
		List<Uspf> list=super.daoSelectUspfById(uscr.getUserid());
		if(list.isEmpty()) {
			return CommonResult.build(400, "no such user");
		}
		else if(!list.get(0).getStatus().equalsIgnoreCase("A")) {
			return CommonResult.build(400, "user expired");
		}
		
		String md5password = DigestUtils.md5DigestAsHex(uscr.getPassword().getBytes());
		uscr.setPassword(md5password);
		super.daoCreateUscr(uscr);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteUscr(String userid) {
		super.daoDeleteUscrById(userid);
		return CommonResult.ok();
	}

	@Override
	public EasyUIDataGridResult searchUscr(Uscr uscr) throws Exception {
		List<Uscr> list = super.daoSearchUscr(uscr);
		
		PageInfo<Uscr> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		return result;
	}

}
