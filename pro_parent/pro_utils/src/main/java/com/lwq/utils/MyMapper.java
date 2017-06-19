package com.lwq.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  MyMapper.java   
 * @Package com.lwq.utils   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年5月7日 下午4:17:58   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
