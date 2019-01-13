package com.sg.cp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.sg.cp.service.JedisClient;

public class JedisCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	@Override
	public List queryList(String key1, String key2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToList(String key1, String key2, List list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long del(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
