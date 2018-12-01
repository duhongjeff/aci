package com.sg.cp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.apache.solr.client.solrj.impl.CloudSolrClient.Builder;


public class SolrCloudTest {

	public static void main(String[] args) throws SolrServerException, IOException {

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSolrCloud() throws SolrServerException, IOException {
		
		
		Builder builder = new CloudSolrClient.Builder();
		builder.withZkHost(Arrays.asList(new String[] { "192.168.1.110:2181,192.168.1.110:2182,192.168.1.110:2183" }));
		CloudSolrClient client = builder.build();
		
		client.setDefaultCollection("collection1");
		
		
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "this is id");
		
		client.add(document);
		
		client.commit();
		client.close();
	}

}
