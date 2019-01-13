package com.sg.cp.service.impl.staticimpl.funcimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.cp.pojo.Fugp;
import com.sg.cp.pojo.Func;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.SearchService;
import com.sg.cp.service.funcservice.FuncService;
import com.sg.cp.service.impl.staticimpl.StaticGeneralService;
import com.sg.cp.service.temporaryservice.TmpSolutionService;

import commontools.CPDateUtils;
import commontools.CommonEnums;
import commontools.CommonEnums.Status;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Service
public class FuncServiceImpl extends StaticGeneralService implements FuncService {

	@Resource(name = "topicDestination")
	private Destination destination;
	
	@Autowired
	private SearchService searchservice;

	@Override
	public EasyUIDataGridResult searchFunc(Func func) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("functionname", func.getFunctionname());

		List<Func> funcList = new ArrayList<Func>();

		SolrDocumentList searchList = searchservice.generalPojoSearch(map, null);

		for (SolrDocument solrDocument : searchList) {
			Func item = new Func();
			List<String> functionid=(List<String>) (solrDocument.getFieldValue("functionid"));
			List<String> functionname=(List<String>)  (solrDocument.getFieldValue("functionname"));
			List<String> desc=(List<String>)  (solrDocument.getFieldValue("desc"));
			item.setFunctionid(Integer.valueOf(functionid.get(0)));
			item.setFunctionname(functionname.get(0));
			System.out.println(item.toString());

			funcList.add(item);
		}
		EasyUIDataGridResult result = new EasyUIDataGridResult();


		return null;
	}
	
	@Override
	public EasyUIDataGridResult getFuncList(Integer page, Integer rows, Status status) {
		/*targetlist = tmpSolutionService.tmpSearchFunctionSolution(new ArrayList());

		 */
			List<Func> list = new ArrayList<Func>();
			// list=jedisClient.queryList(LIST, USERLISTKEY);

			// 1.设置分页的信息 使用pagehelper
			if (page == null)
				page = 1;
			if (rows == null)
				rows = 30;
			PageHelper.startPage(page, rows);

			// 4.根据mapper调用查询所有数据的方法
			list = daoGetFuncList(status);
			
		
		// 5.获取分页的信息
		PageInfo<Func> info = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		// 7.返回

		// 向缓存中添加数据
		// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
		return result;
	}

	@Override
	public CommonResult updateFunc(Func func) {
		String errormsg=super.daoUpdateFunc(func);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteFunc(int funcId) {
		String msg=null;
		msg=super.daoDeleteFuncById(funcId);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createFunc(Func func) {
		// 3.插入内容表中
		String msg=super.daoCreateFunc(func);
		return CommonResult.ok();
	}

	@Override
	public EasyUIDataGridResult getFugpList(Integer page, Integer rows, Status status) {
		List<Fugp> list = new ArrayList<Fugp>();
		// list=jedisClient.queryList(LIST, USERLISTKEY);

		// 1.设置分页的信息 使用pagehelper
		if (page == null)
			page = 1;
		if (rows == null)
			rows = 30;
		PageHelper.startPage(page, rows);

		// 4.根据mapper调用查询所有数据的方法
		list = daoGetFugpList(status);
		
	
	// 5.获取分页的信息
	PageInfo<Fugp> info = new PageInfo<>(list);
	EasyUIDataGridResult result = new EasyUIDataGridResult();
	result.setTotal((int) info.getTotal());
	result.setRows(info.getList());
	// 7.返回

	// 向缓存中添加数据
	// jedisClient.addToList(LIST, USERLISTKEY, targetlist);
	return result;
	}

	@Override
	public CommonResult updateFugp(Fugp fugp) {
		String errormsg=super.daoUpdateFugp(fugp);
		return CommonResult.ok();
	}

	@Override
	public CommonResult deleteFugp(int fugpId) {
		String msg=null;
		msg=super.daoDeleteFugpById(fugpId);
		return CommonResult.ok();
	}

	@Override
	public CommonResult createFugp(Fugp fugp) {
		// 2.补全其他的属性
		// 3.插入内容表中
		String msg=super.daoCreateFugp(fugp);
		return CommonResult.ok();
	}


	
	//TODO 不应该在这里做分页
	
}
