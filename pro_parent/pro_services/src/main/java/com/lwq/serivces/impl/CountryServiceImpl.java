package com.lwq.serivces.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import com.github.pagehelper.PageHelper;
import com.lwq.model.Country;
import com.lwq.serivces.CountryService;

/***
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  CountryServiceImpl.java   
 * @Package com.lwq.serivces.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年5月7日 下午4:13:24   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
@Service("countryService")
public class CountryServiceImpl extends BaseService<Country> implements CountryService {

    public List<Country> selectByCountry(Country country, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(country.getCountryname())) {
            criteria.andLike("countryname", "%" + country.getCountryname() + "%");
        }
        if (StringUtil.isNotEmpty(country.getCountrycode())) {
            criteria.andLike("countrycode", "%" + country.getCountrycode() + "%");
        }
        if (country.getId() != null) {
            criteria.andLike("id", country.getId()+"");
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

}
