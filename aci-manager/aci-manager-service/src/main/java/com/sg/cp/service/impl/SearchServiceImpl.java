package com.sg.cp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sg.cp.mapper.SearchItemMapper;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.SearchService;
import com.sg.cp.service.dao.SearchDao;
import commontools.CommonEnums.AndOrNull;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Value("${LIST_KEY}") private String LIST;
	@Value("${SEARCH_LIST_KEY}") private String SEARCHLIST;
	@Autowired private JedisClient jedisClient;
	
	@Autowired
	private SearchItemMapper mapper;

	@Autowired
	private SolrClient solrserver;

	@Autowired
	private SearchDao searchdao;

	@Override
	public CommonResult importAllSearchItems() throws Exception {
		// 1.注入mapper
		// 2.调用mapper的方法 查询所有的商品的数据
		/*
		 * List<SearchUspf> searchItemList = mapper.getSearchUspfList(); //3.通过solrj
		 * 将数据写入到索引库中 //3.1创建httpsolrserver //3.2 创建solrinputdocument 将 列表中的元素一个个放到索引库中
		 * for (SearchUspf searchUspf : searchItemList) { SolrInputDocument document =
		 * new SolrInputDocument(); document.addField("id",
		 * searchUspf.getUserid().toString());//这里是字符串需要转换 document.addField("username",
		 * searchUspf.getUsername());//这里是字符串需要转换 document.addField("position",
		 * searchUspf.getPosition());//这里是字符串需要转换 //添加到索引库 solrserver.add(document); }
		 * //提交 solrserver.commit(); return CommonResult.ok();
		 */
		return null;
	}

	@Override
	public SolrDocumentList searchSolrDocumentList(Map<String,String> map) throws Exception {
		SolrDocumentList searchList = searchdao.search(map, AndOrNull.AND);
		return searchList;

	}

}
