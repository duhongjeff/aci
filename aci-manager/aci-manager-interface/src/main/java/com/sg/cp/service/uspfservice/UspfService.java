package com.sg.cp.service.uspfservice;
import java.util.List;
import java.util.Map;

import com.sg.cp.pojo.Uscr;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;

import commontools.CommonEnums.Status;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

public interface UspfService {
	public EasyUIDataGridResult getUspfList(Integer page,Integer rows, Status status);
	public String[] getUspfDisplayList(Status status);
	public List<Uspf> getUspfList(Status status);
	
	public CommonResult updateUspf(Uspf uspf);
	public CommonResult createUspf(Uspf uspf);
	public CommonResult deleteUspf(String userid);
	public EasyUIDataGridResult searchUspf(Map<String,String> map, String className) throws Exception;
	
	public CommonResult updateUscr(Uscr uscr);
	public CommonResult createUscr(Uscr uscr);
	public CommonResult deleteUscr(String userid);
	public EasyUIDataGridResult searchUscr(Uscr uscr) throws Exception;
	
	public EasyUIDataGridResult getUspfGrpList(Integer page, Integer rows, Status status);
	public CommonResult updateUsgp(Usgp usgp);
	public CommonResult createUsgp(Usgp usgp);
	public CommonResult deleteUsgp(String userid);
	public EasyUIDataGridResult searchUsgp(Usgp usgp) throws Exception;
	public CommonResult matchUsgp(List<Map<String,String>> list);
	
	public CommonResult getUsgpAndMatchingUsers();
}
