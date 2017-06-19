package com.lwq.mapper;

import java.util.List;

import com.lwq.model.User;
import com.lwq.utils.MyMapper;

public interface UserMapper  extends MyMapper<User>{
	
		/**
		 * 登录
		* @Title: login
		* @Description: TODO(这里用一句话描述这个方法的作用)
		* @param @param map
		* @param @return    设定文件
		* @return User    返回类型
		* @throws
		 */
	java.util.Map<String, Object>  login (java.util.Map<String, Object> map);
	
	List<java.util.Map<String, Object>>  list (java.util.Map<String, Object> map);
}
