package com.sg.cp;


public class SolrjTest {
	//@Test
	/*
	public void add() throws Exception{
		//1.创建solrserver   建立连接 需要指定地址
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.110:8983/fooSearch/core1/");
		//2.创建solrinputdocument
		SolrInputDocument document = new SolrInputDocument();
		
		//3.向文档中添加域
		document.addField("id", "1");
		document.addField("username", "duhong");
		document.addField("position", "manager");
		//4.将文档提交到索引库中
		solrServer.add(document);
		//5.提交
		solrServer.commit();
	}
	
	//@Test
	public void delete() throws Exception{
		//1.创建solrserver   建立连接 需要指定地址
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.110:8983/fooSearch/core1/");
		
		solrServer.deleteById("test001");
		//5.提交
		solrServer.commit();
	}
	
	//@Test
	public void deleteDocumentByQuery() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.110:8983/fooSearch/core1/");
		solrServer.deleteByQuery("item_title:change.me");
		solrServer.commit();
	}
	
	//@Test
	public void testquery() throws Exception{
		//1.创建solrserver对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.110:8983/fooSearch/core1/");
		//2.创建solrquery对象   设置各种过滤条件，主查询条件 排序
		SolrQuery query = new SolrQuery();
		//3.设置查询的条件
		query.setQuery("阿尔卡特");
		query.addFilterQuery("item_price:[0 TO 300000000]");
		query.set("df", "item_title");
		//4.执行查询
		QueryResponse response = solrServer.query(query);
		//5.获取结果集
		SolrDocumentList results = response.getResults();
		System.out.println("查询的总记录数"+results.getNumFound());
		//6.遍历结果集  打印
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
		}
	}
	
	//@Test
	public void queryDocument() throws Exception {
		// 第一步：创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.110:8983/fooSearch/core1/");
		// 第二步：创建一个SolrQuery对象。
		SolrQuery query = new SolrQuery();
		// 第三步：向SolrQuery中添加查询条件、过滤条件。。。
		query.setQuery("*:*");
		// 第四步：执行查询。得到一个Response对象。
		QueryResponse response = solrServer.query(query);
		// 第五步：取查询结果。
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("查询结果的总记录数：" + solrDocumentList.getNumFound());
		// 第六步：遍历结果并打印。
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}
	}
	*/
}
