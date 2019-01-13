package com.sg.cp.service.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.cp.model.UspfEnh;

import commontools.CommonEnums.AndOrNull;
import commontools.Stack;
import solrtools.SearchResult;



/**
 * 从索引库中搜索商品的dao 
 * @title SearchDao.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
@Repository
public class SearchDao {
	@Autowired
	private SolrClient solrServer;
	/**
	 * 根据查询的条件查询商品的结果集
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public SolrDocumentList solrSearch(Map<String,String> targetMap,AndOrNull aon) {
		
		SolrQuery query = new SolrQuery();
		
		if(targetMap.isEmpty())
		{
			query.setQuery("*:*");
		}
		else
		{
			String finalquery="";
		    
		    Iterator<Map.Entry<String, String>> iterator = targetMap.entrySet().iterator();
		    while (iterator.hasNext()) {
		        Map.Entry<String, String> entry = iterator.next();
		        finalquery=entry.getKey()+":"+entry.getValue()+" ";
		    	if(aon.equals(AndOrNull.AND))
				{	
					if(iterator.hasNext()) finalquery=finalquery+AndOrNull.AND.name();
				}
		    	else if(aon.equals(AndOrNull.Or))
				{
					if(iterator.hasNext()) finalquery=finalquery+AndOrNull.Or.name();
				}
		    }
		   
		    query.setQuery(finalquery);
					
		}
		
		//2.1设置过滤条件 设置分页
		query.setStart(0);//page-1 * rows
		query.setRows(60);
		
		
		//1.创建solrserver对象 由spring管理 注入
		//2.直接执行查询
		QueryResponse response=null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//3.获取结果集
		if(response!=null)
			return  response.getResults();
		else
			return null;
	}
}
