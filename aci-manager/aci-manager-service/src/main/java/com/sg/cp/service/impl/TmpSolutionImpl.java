package com.sg.cp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sg.cp.model.UsgpEnh;
import com.sg.cp.model.UspfEnh;
import com.sg.cp.pojo.Usgp;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.temporaryservice.TmpSolutionService;


@Service
public class TmpSolutionImpl implements TmpSolutionService {
	
	@Value("${LIST_KEY}") private String LIST;
	@Value("${SEARCH_LIST_KEY}") private String SEARCHLIST;
	@Autowired private JedisClient jedisClient;

	public List tmpSearchFunctionSolution(List<Uspf> list) {
		list=jedisClient.queryList(LIST, SEARCHLIST);
		if(list!=null && list.size()>0)
		{
			List<UspfEnh> targetlist = new ArrayList<UspfEnh>();
			UspfEnh enh;
			for(Uspf p : list)
			{
				enh=new UspfEnh();
				enh.setUserid(p.getUserid());
				enh.setRealname(p.getRealname());
				enh.setReporterid(p.getReporterid());
				enh.setGender(p.getGender());
				enh.setEmail(p.getEmail());
				enh.setStatus(p.getStatus());
				
				targetlist.add(enh);
			}
			
			jedisClient.hdel(LIST, SEARCHLIST);
		}
		return list;
		
	}
	
	public List tmpSearchFunctionSolutionForUsgp(List<Usgp> list) {
		list=jedisClient.queryList(LIST, SEARCHLIST);
		if(list!=null && list.size()>0)
		{
			List<UsgpEnh> targetlist = new ArrayList<UsgpEnh>();
			UsgpEnh enh;
			for(Usgp p : list)
			{
				enh=new UsgpEnh();
				enh.setUsgpiddesc(p.getUsgpid().toString());
				enh.setUsgpname(p.getUsgpname());
				
				targetlist.add(enh);
			}
			
			jedisClient.hdel(LIST, SEARCHLIST);
		}
		return list;
		
	}
}
