package com.sg.cp.service.impl.ssoimpl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sg.cp.mapper.UspfMapper;
import com.sg.cp.pojo.Uspf;
import com.sg.cp.pojo.UspfExample;
import com.sg.cp.service.JedisClient;
import com.sg.cp.service.sso.UserLoginService;

import commontools.JsonUtils;
import easyuitools.CommonResult;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UspfMapper usermapper;
	@Autowired
	private JedisClient client;
	
	@Value("${USER_INFO}")
	private String USER_INFO;
	@Value("${EXPIRE_TIME}")
	private Integer EXPIRE_TIME;

	@Override
	public CommonResult login(String userid, String password) {
		//1.注入mapper
		//2.校验用户名和密码是否为空
		if(StringUtils.isEmpty(userid) || StringUtils.isEmpty(password)){
			return CommonResult.build(400, "1用户名或密码错误");
		}
		//3.先校验用户名
		List<Uspf> list = usermapper.selectuspfanduscr("A",userid);
		if(list==null || list.size()==0){
			return CommonResult.build(400, "2用户名或密码错误");
		}
		//4.再校验密码
		Uspf user = list.get(0);
		System.out.println(user.toString());
		//先加密密码再比较
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
		if(!md5DigestAsHex.equals(user.getUscr().getPassword())){//表示用户的密码不正确
			return CommonResult.build(400, "3用户名或密码错误");
		}
		//5.如果校验成功
		//6.生成token : uuid生成    ，还需要设置token的有效性期来模拟session  用户的数据存放在redis  (key:token,value:用户的数据JSON)
		String token = UUID.randomUUID().toString();
		//存放用户数据到redis中，使用jedis的客户端,为了管理方便加一个前缀"kkk:token"
		//设置密码为空
		user.getUscr().setPassword(null);
		client.set(USER_INFO+":"+token, JsonUtils.objectToJson(user));
		//设置过期时间 来模拟session
		client.expire(USER_INFO+":"+token, EXPIRE_TIME);
		//7.把token设置cookie当中    在表现层设置
		return CommonResult.ok(token);
	}

	@Override
	public CommonResult getUserByToken(String token) {
		//1.注入jedisclient
		//2.调用根据token查询 用户信息（JSON）的方法   get方法
		String strjson = client.get(USER_INFO+":"+token);
		//3.判断是否查询到
		if(StringUtils.isNotBlank(strjson)){
			//5.如果查询到  需要返回200  包含用户的信息  用户信息转成对象
			Uspf user = JsonUtils.jsonToPojo(strjson, Uspf.class);
			//重新设置过期时间
			client.expire(USER_INFO+":"+token, EXPIRE_TIME);
			return CommonResult.ok(user);
		}
		//4.如果查询不到 返回400
		return CommonResult.build(400, "用户已过期");
	}

}
