package com.sg.cp.service;

import com.sg.cp.pojo.Uspf;

import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

public interface UspfService {
	public EasyUIDataGridResult getUspfList(Integer page,Integer rows, String string);
	public CommonResult updateUspf(Uspf uspf);
	public CommonResult createUspf(Uspf uspf);
	public CommonResult deleteUspf(String userid);
	public EasyUIDataGridResult getUspfGrpList(Integer page, Integer rows);
}
