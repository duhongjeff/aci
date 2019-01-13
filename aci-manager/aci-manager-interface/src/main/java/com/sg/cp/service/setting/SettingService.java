package com.sg.cp.service.setting;
import java.util.List;

import com.sg.cp.pojo.Drev;
import com.sg.cp.pojo.Item;

import easyuitools.CommonResult;

public interface SettingService {
	public CommonResult setWeekends(String year);
	public Item getItemByName(String prodname,String itemname);
	public CommonResult setDrev(List<Drev> list);
}
