package com.sg.cp.service.temporaryservice;

import java.util.List;

import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;

import easyuitools.CommonResult;
import easyuitools.EasyUIDataGridResult;

public interface TmpSolutionService {
	public List tmpSearchFunctionSolution(List<Uspf> list);
	public List tmpSearchFunctionSolutionForUsgp(List<Usgp> list);
}
