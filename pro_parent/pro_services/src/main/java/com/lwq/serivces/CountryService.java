package com.lwq.serivces;

import java.util.List;

import com.lwq.model.Country;

/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  CountryService.java   
 * @Package com.lwq.serivces   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年5月7日 下午4:13:31   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
public interface CountryService extends IService<Country> {

    /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Country> selectByCountry(Country country, int page, int rows);

}
