package com.sg.cp.service.impl.settingimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.cp.mapper.DrevMapper;
import com.sg.cp.mapper.HdayMapper;
import com.sg.cp.mapper.ItemMapper;
import com.sg.cp.pojo.Drev;
import com.sg.cp.pojo.DrevExample;
import com.sg.cp.pojo.Hday;
import com.sg.cp.pojo.Item;
import com.sg.cp.pojo.ItemExample;
import com.sg.cp.pojo.UsgpExample;
import com.sg.cp.service.setting.SettingService;

import easyuitools.CommonResult;

@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	private HdayMapper hdaymapper;
	@Autowired
	private ItemMapper itemmapper;
	@Autowired
	private DrevMapper drevMapper;

	@Override
	public CommonResult setWeekends(String y) {
		int year = Integer.valueOf(y);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, year);
		int daysInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

		for (int d = 1; d <= daysInYear; d++) {
			calendar.set(Calendar.DAY_OF_YEAR, d);
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			boolean re = (day == Calendar.SUNDAY || day == Calendar.SATURDAY);
			if (re) {
				Hday hday = new Hday();
				hday.setCountry("CN");
				hday.setIsweekend("Y");
				hday.setIsholiday("N");
				hday.setHdate(calendar.getTime());
				hdaymapper.insertSelective(hday);
			}
			System.out.println("day of the year: " + d + " re: " + re + " date: " + calendar.getTime());
		}
		return CommonResult.ok();
	}

	@Override
	public Item getItemByName(String prodname, String itemname) {
		List<Item> list = itemmapper.selectItemUnderProduct(prodname, itemname);
		return list.get(0);
	}

	@Override
	public CommonResult setDrev(List<Drev> list) {
		try {
			List<Drev> insertList = new ArrayList<Drev>();

			for (Drev d : list) {

				DrevExample example = new DrevExample();
				com.sg.cp.pojo.DrevExample.Criteria criteria = example.createCriteria();
				criteria.andTransdateEqualTo(d.getTransdate()).andItemidEqualTo(d.getItemid());
				List<Drev> duplicate = drevMapper.selectByExample(example);
				if (duplicate.isEmpty()) {
					insertList.add(d);
					continue;
				}
				drevMapper.updateByExampleSelective(d, example);

			}

			for (Drev d : insertList) {
				drevMapper.insertSelective(d);
			}
		} catch (Exception ex) {
			return CommonResult.build(500, ex.getMessage());
		}

		return CommonResult.ok();
	}

}
