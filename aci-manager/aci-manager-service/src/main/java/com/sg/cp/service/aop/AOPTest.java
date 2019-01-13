package com.sg.cp.service.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AOPTest {
	    private static final String GMTCREATE   = "credate";
	    private static final String CREBY       = "creby";
	    private static final String GMTUPEATE   = "lupdate";
	    private static final String LUPBY       = "lupby";
	    

	    public void beforeInsert(JoinPoint jp) {
	    	System.out.println("here I am in Aop Insert");
	    	
	         
	        Object[] args = jp.getArgs();
	        if (args != null && args.length > 0) {
	            Object argument = args[0];
	            
	            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
	            // 设置创建时间和修改时间
	            if (beanWrapper.isWritableProperty(GMTCREATE)) {
	                beanWrapper.setPropertyValue(GMTCREATE, new Date());
	            }
	            if (beanWrapper.isWritableProperty(CREBY)) {
	            	//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	            	//String currUser=CookieUtils.getCookieValue(request, "CURR_USER");
	                beanWrapper.setPropertyValue(CREBY,"tmp");
	            }
	        }
	        
	    }
	    
	    public void beforeUpdate(JoinPoint jp) {
	    	System.out.println("here I am in Aop Update");
	         
	        Object[] args = jp.getArgs();
	        if (args != null && args.length > 0) {
	            Object argument = args[0];
	            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
	            // 设置创建时间和修改时间
	            if (beanWrapper.isWritableProperty(GMTUPEATE)) {
	                beanWrapper.setPropertyValue(GMTUPEATE, new Date());
	            }
	            if (beanWrapper.isWritableProperty(LUPBY)) {
	            	//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	            	//String currUser=CookieUtils.getCookieValue(request, "CURR_USER");
	                beanWrapper.setPropertyValue(LUPBY,"tmp");
	            }
	        }
	        
	    }
}
