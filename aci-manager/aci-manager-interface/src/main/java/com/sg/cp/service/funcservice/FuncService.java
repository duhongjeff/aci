package com.sg.cp.service.funcservice;

import com.sg.cp.pojo.Fugp;
import com.sg.cp.pojo.Func;

import commontools.CommonEnums.Status;
import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

public interface FuncService {
	public EasyUIDataGridResult getFuncList(Integer page,Integer rows, Status status);
	public CommonResult updateFunc(Func func);
	public CommonResult deleteFunc(int funcId);
	public CommonResult createFunc(Func func);
	public EasyUIDataGridResult searchFunc(Func func) throws Exception;
	
	public EasyUIDataGridResult getFugpList(Integer page,Integer rows, Status status); 
	public CommonResult updateFugp(Fugp fugp);
	public CommonResult deleteFugp(int fugpId);
	public CommonResult createFugp(Fugp fugp);
	
}
