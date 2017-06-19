package com.lwq.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.JedisPool;

import com.github.pagehelper.PageInfo;
import com.lwq.model.Country;
import com.lwq.serivces.CountryService;
/**
 * 
 * All rights Reserved, Designed By lwq
 * @Title:  CountryController.java   
 * @Package com.lwq.contorller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 上海易往     
 * @date:   2017年5月7日 下午4:11:35   
 * @version V1.0 
 * @Copyright: 2017 lwq. All rights reserved. 
 *
 */
@Controller
public class CountryController {

    @Autowired
     CountryService countryService;
    
    //redis
    @Autowired JedisPool jedisPool;
    
    private String page_list = "index";

    private String redirect_list = "redirect:list";

    @RequestMapping(value = {"list", "index", "index.html", ""})
    public ModelAndView getList(Country country,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
    	
        ModelAndView result = new ModelAndView(page_list);
        List<Country> countryList = countryService.selectByCountry(country, page, rows);
        result.addObject("pageInfo", new PageInfo<Country>(countryList));
        result.addObject("queryParam", country);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(Country country) {
        ModelAndView result = new ModelAndView();
        if (country.getId() != null) {
            country = countryService.selectByKey(country.getId());
        }
        result.addObject("country", country);
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(Country country) {
        ModelAndView result = new ModelAndView(redirect_list);
        if (country.getId() != null) {
            countryService.updateAll(country);
        } else {
            countryService.save(country);
        }
        return result;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        countryService.delete(id);
        return redirect_list;
    }

}
