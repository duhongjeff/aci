package com.sg.cp.service.impl.staticimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sg.cp.mapper.FugpMapper;
import com.sg.cp.mapper.FuncMapper;
import com.sg.cp.mapper.UsgpMapper;
import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.pojo.Fugp;
import com.sg.cp.pojo.FugpExample;
import com.sg.cp.pojo.FugpExample.Criteria;
import com.sg.cp.pojo.Func;
import com.sg.cp.pojo.FuncExample;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.UsgpExample;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.pojo.UspfExample;

import commontools.CPDateUtils;
import commontools.CommonEnums;
import commontools.CommonEnums.Status;


@Service
public class StaticGeneralService{

	@Autowired
	private UspfMapper uspfmapper;
	@Autowired
	private UsgpMapper usgpmapper;
	@Autowired
	private FuncMapper funcMapper;
	@Autowired
	private FugpMapper fugpMapper;

	@Value("${USERLIST_KEY}") private String USERLISTKEY;
	@Value("${USERGRPLIST_KEY}") private String USERGRPLIST_KEY;
	@Value("${LIST_KEY}") private String LIST;
	@Value("${SEARCH_LIST_KEY}") private String SEARCHLIST;

	@Resource(name = "topicDestination")
	private Destination destination;
	
	
	/*------------------------------------Uspf----------------------------------------------*/
	//Create
	protected String daoCreateUspf(Uspf uspf) {
		String msg = null;
		uspfmapper.insertSelective(uspf);
		return msg;
	}
	
	//Delete
	protected String daoDeleteUspfById(String uspfid) {
		String msg = null;
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uspfid);
		uspfmapper.deleteByExample(example);
		return msg;
	}
	
	
	//List
	protected List<Uspf> daoGetUspfList(Status status){
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria usfpCriteria = example.createCriteria();
		usfpCriteria.andStatusEqualTo(status.name());
		return uspfmapper.selectByExample(example);
	}
	
	protected List<Uspf> daoSelectUspfwithUsgp(Status status){
		return uspfmapper.selectuspfandusgp(status.name());
	}
	
	//Update
	protected String daoUpdateUspf(Uspf uspf) {
		
		String msg = null;
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uspf.getUserid());
		uspfmapper.updateByExampleSelective(uspf, example);
		return msg;
	}
	
	/*------------------------------------Usgp ----------------------------------------------*/
	//Create
	protected String daoCreateUsgp(Usgp usgp) {
		String msg = null;
		usgpmapper.insertSelective(usgp);
		return msg;
	}
	
	//Delete
	protected String daoDeleteUsgpById(Integer usgpId) {
		String msg = null;
		UsgpExample example = new UsgpExample();
		com.sg.cp.pojo.UsgpExample.Criteria criteria = example.createCriteria();
		criteria.andUsgpidEqualTo(usgpId);
		usgpmapper.deleteByExample(example);
		return msg;
	}
	
	//List
	protected List<Usgp> daoGetUsgpList(Status status){
		UsgpExample example = new UsgpExample();
		com.sg.cp.pojo.UsgpExample.Criteria usgpCriteria = example.createCriteria();
		usgpCriteria.andStatusEqualTo(status.name());
		return usgpmapper.selectByExample(example);
	}
	
	//Update
	protected String daoUpdateUsgp(Usgp usgp) {
		
		String msg = null;
		UsgpExample example = new UsgpExample();
		com.sg.cp.pojo.UsgpExample.Criteria criteria = example.createCriteria();
		criteria.andUsgpidEqualTo(usgp.getUsgpid());
		usgpmapper.updateByExampleSelective(usgp, example);
		return msg;
	}
	
	//-------------------Func-------------------------------
	//List
	protected List<Func> daoGetFuncList(Status status){
		FuncExample example = new FuncExample();
		com.sg.cp.pojo.FuncExample.Criteria funcCriteria = example.createCriteria();
		funcCriteria.andActiveEqualTo(status.name());
		return funcMapper.selectByExample(example);
	}
	
	//Update
	protected String daoUpdateFunc(Func func) {
		
		String msg = null;
		FuncExample example = new FuncExample();
		com.sg.cp.pojo.FuncExample.Criteria funcCriteria = example.createCriteria();
		funcCriteria.andFunctionidEqualTo(func.getFunctionid());
		funcMapper.updateByExampleSelective(func, example);
		return msg;
	}
	
	//Delete
	protected String daoDeleteFuncById(int funcId) {
		String msg = null;
		FuncExample example = new FuncExample();
		com.sg.cp.pojo.FuncExample.Criteria funcCriteria = example.createCriteria();
		funcCriteria.andFunctionidEqualTo(funcId);
		funcMapper.deleteByExample(example);
		return msg;
	}
	
	//Create
	protected String daoCreateFunc(Func func) {
		String msg = null;
		funcMapper.insertSelective(func);
		return msg;
	}
	
	//-------------------Fugp-------------------------------
	//List
	protected List<Fugp> daoGetFugpList(Status status){
		FugpExample example = new FugpExample();
		com.sg.cp.pojo.FugpExample.Criteria fugpCriteria = example.createCriteria();
		return fugpMapper.selectByExample(example);
	}
	
	//Update
	protected String daoUpdateFugp(Fugp fugp) {
		
		String msg = null;
		FugpExample example = new FugpExample();
		com.sg.cp.pojo.FugpExample.Criteria fugpCriteria = example.createCriteria();
		fugpCriteria.andFuctiongpidEqualTo(fugp.getFuctiongpid());
		fugpMapper.updateByExampleSelective(fugp, example);
		return msg;
	}
	
	//Delete
	protected String daoDeleteFugpById(int fugpId) {
		String msg = null;
		FugpExample example = new FugpExample();
		com.sg.cp.pojo.FugpExample.Criteria fugpCriteria = example.createCriteria();
		fugpCriteria.andFuctiongpidEqualTo(fugpId);
		fugpMapper.deleteByExample(example);
		return msg;
	}
	
	//Create
	protected String daoCreateFugp(Fugp fugp) {
		String msg = null;
		fugpMapper.insertSelective(fugp);
		return msg;
	}
}
