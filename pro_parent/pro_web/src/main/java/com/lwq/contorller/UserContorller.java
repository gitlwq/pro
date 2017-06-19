package com.lwq.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.JedisPool;

import com.lwq.interceptor.annotation.Auth;
import com.lwq.mapper.UserMapper;
import com.lwq.utils.FastJsonUtils;
/**
 * wqli
* @ClassName: UserContorller
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年6月15日 下午1:58:36
*
 */
@RestController
@RequestMapping("/user")
public class UserContorller {
	
	@Autowired UserMapper userMapper;
	
	  //redis
    @Autowired JedisPool jedisPool;
	
//    @Auth
	@RequestMapping("/login")
	public String login(String uname,String upass){
		String token="";
		HashMap<String, Object> newHashMap = new   HashMap<String, Object>();
		newHashMap.put("uname",uname);
		newHashMap.put("upass",upass);
		java.util.Map<String, Object> map= userMapper.login(newHashMap);
		if(map!=null){
			
			token=UUID.randomUUID().toString();
			jedisPool.getResource().set("token:"+token, FastJsonUtils.Object2JsonString(map));
			
		}else{
			
		}
		
		
		return token;
		
	}
	/**
	 * user list
	* @Title: list
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/list")
	public String list(){
		String token="";
		HashMap<String, Object> newHashMap = new   HashMap<String, Object>();
		List<java.util.Map<String, Object>> map= userMapper.list(newHashMap);
		
		return FastJsonUtils.Object2JsonString(map);
		
	}
	
	
	
	
	
}
