package com.sg.cp.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sg.cp.model.UspfEnh;
import com.sg.cp.service.uspfservice.UspfService;

import commontools.CommonEnums.Status;
import easyuitools.EasyUIDataGridResult;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class GenHtmMessageListener implements MessageListener {

	@Autowired private UspfService uspfService;
	@Autowired private FreeMarkerConfigurer config;
	
	@Override
	public void onMessage(Message message) {
		System.out.println("1");
		if(message instanceof TextMessage) {
			System.out.println("2");
			TextMessage message2 = (TextMessage) message;
			try {
				System.out.println("3");
				String status = message2.getText();
				System.out.println("getText is "+status);
				EasyUIDataGridResult uspfResult= uspfService.getUspfList(1, 30, Status.A);
				List<UspfEnh> uspfList=uspfResult.getRows();
				System.out.println(uspfResult.toString());
				genHtmlFreemarker(uspfList.get(0),"test");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void genHtmlFreemarker(UspfEnh uspf, String string) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		Configuration configuration = config.getConfiguration();
		Template template = configuration.getTemplate("item.ftl");
		Map model=new HashMap<>();
		model.put("uspf", uspf);
		model.put("uspfDesc", "test");
		Writer writer = new FileWriter(new File("D:\\AFileTransfer\\uspf"+uspf.getUserid()+".html"));
		
	}

}
