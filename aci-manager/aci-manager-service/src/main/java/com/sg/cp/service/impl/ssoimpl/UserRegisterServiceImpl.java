package com.sg.cp.service.impl.ssoimpl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sg.cp.mapper.UscrMapper;
import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.pojo.Uscr;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.pojo.UspfExample;
import com.sg.cp.service.sso.UserRegisterService;

import commontools.CommonEnums.Status;
import easyuitools.CommonResult;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	@Autowired
	private UspfMapper usermapper;
	@Autowired
	private UscrMapper uscrmapper;

	@Override
	public CommonResult checkData(String param, Integer type) {
		//1.注入mapper
		//2.根据参数动态的生成查询的条件
		UspfExample example = new UspfExample();
		com.sg.cp.pojo.UspfExample.Criteria criteria = example.createCriteria();
		if(type==1){//username
			if(StringUtils.isEmpty(param)){
				return CommonResult.ok(false);
			}
			criteria.andUseridEqualTo(param);
		}else if(type==2){
			//phone
			criteria.andTelnoEqualTo(param);
		}else if(type==3){
			//email
			criteria.andEmailEqualTo(param);
		}else{
			//是非法的参数    
			//return 非法的
			return CommonResult.build(400, "非法的参数");
		}
		//3.调用mapper的查询方法 获取数据   
		List<Uspf> list = usermapper.selectByExample(example);
		//4.如果查询到了数据   --数据不可以用   false
		if(list!=null && list.size()>0){
			return CommonResult.ok(false);
		}
		//5.如果没查到数据  ---数据是可以用  true
		return CommonResult.ok(true);
	}

	@Override
	public CommonResult register(Uspf uspf) {
		//1.注入mapper
		//2.校验数据
			//2.1 校验用户名和密码不能为空
		
		if(StringUtils.isEmpty(uspf.getUserid())){
			return CommonResult.build(400, "注册失败1. 请校验数据后请再提交数据");
		}
		if(StringUtils.isEmpty(uspf.getUscr().getPassword())){
			return CommonResult.build(400, "注册失败.2 请校验数据后请再提交数据");
		}
			//2.2 校验用户名是否被注册了
		CommonResult result = checkData(uspf.getUserid(),1);
		if(!(boolean)result.getData()){
			//数据不可用
			return CommonResult.build(400, "注册失败3. 请校验数据后请再提交数据");
		}
			//2.3 校验电话号码是否被注册了
		if(StringUtils.isNotBlank(uspf.getTelno())){
			CommonResult result2 = checkData(uspf.getTelno(),2);
			if(!(boolean)result2.getData()){
				//数据不可用
				return CommonResult.build(400, "注册失败4. 请校验数据后请再提交数据");
			}
		}
			//2.4 校验email是否被注册了
		if(StringUtils.isNotBlank(uspf.getEmail())){
			CommonResult result2 = checkData(uspf.getEmail(),3);
			if(!(boolean)result2.getData()){
				//数据不可用
				return CommonResult.build(400, "注册失败5. 请校验数据后请再提交数据");
			}
		}
		
		//3.如果校验成功   补全其他的属性
		//4.对密码进行MD5加密
		String md5password = DigestUtils.md5DigestAsHex(uspf.getUscr().getPassword().getBytes());
		//5.插入数据
		Uscr uscr = new Uscr();
		uspf.setStatus(Status.A.name());
		uscr.setStatus(Status.A.name());
		usermapper.insertSelective(uspf);
		
		uscr.setUserid(uspf.getUserid());
		uscr.setPassword(md5password);
		uscrmapper.insertSelective(uscr);
		
		//6.返回taotaoresult
		return CommonResult.ok();
	}

}
