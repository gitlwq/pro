package com.lwq.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * alibaba fastjson utils
 * 
 * @see https://github.com/alibaba/fastjson/wiki
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2015-04-07
 */
public final class FastJsonUtils {
	public static <T> void writeJsonToFile(T t, File file) throws IOException {
		String jsonStr = JSONObject.toJSONString(t,
				SerializerFeature.PrettyFormat);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file)));
		bw.write(jsonStr);
		bw.close();
	}

	public static <T> void writeJsonToFile(T t, String filename)
			throws IOException {
		writeJsonToFile(t, new File(filename));
	}

	public static <T> T readJsonFromFile(Class<T> cls, File file)
			throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), cls);
	}

	public static <T> T readJsonFromFile(Class<T> cls, String filename)
			throws IOException {
		return readJsonFromFile(cls, new File(filename));
	}

	public static <T> T readJsonFromFile(TypeReference<T> typeReference,
			File file) throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), typeReference);
	}

	public static <T> T readJsonFromFile(TypeReference<T> typeReference,
			String filename) throws IOException {
		return readJsonFromFile(typeReference, new File(filename));
	}
	  public static final <T> List<T> getList(String jsontext, String list_str,  
	            Class<T> clazz) {  
	        JSONObject jsonobj = JSON.parseObject(jsontext);  
	        if (jsonobj == null) {  
	            return null;  
	        }  
	        Object obj = jsonobj.get(list_str);  
	        if (obj == null) {  
	            return null;  
	        }  
	        // if(obj instanceof JSONObject){}  
	        if (obj instanceof JSONArray) {  
	            JSONArray jsonarr = (JSONArray) obj;  
	            List<T> list = new ArrayList<T>();  
	            for (int i = 0; i < jsonarr.size(); i++) {  
	                list.add(jsonarr.getObject(i, clazz));  
	            }  
	            return list;  
	        }  
	        return null;  
	    }  
	  
	    /**  
	     * @param <T>  
	     *            -> DepartmentBean  
	     * @param jsontext  
	     *            -> {"department":{"id":"1","name":"生产部"},"password":"admin",  
	     *            "username":"admin"}  
	     * @param obj_str  
	     *            -> department  
	     * @param clazz  
	     *            -> DepartmentBean  
	     * @return -> T  
	     */  
	    public static final <T> T getObject(String jsontext, String obj_str,  
	            Class<T> clazz) {  
	        JSONObject jsonobj = JSON.parseObject(jsontext);  
	        if (jsonobj == null) {  
	            return null;  
	        }  
	  
	        Object obj = jsonobj.get(obj_str);  
	        if (obj == null) {  
	            return null;  
	        }  
	  
	        if (obj instanceof JSONObject) {  
	            return jsonobj.getObject(obj_str, clazz);  
	        } else {  
	        }  
	  
	        return null;  
	    }  
	  
	    /**  
	     * @param <T>  
	     * @param jsontext  
	     *            ->{"department":{"id":"1","name":"生产部"},"password":"admin",  
	     *            "username":"admin"}  
	     * @param clazz  
	     *            -> UserBean.class  
	     * @return -> UserBean  
	     */  
	    // 注：传入任意的jsontext,返回的T都不会为null,只是T的属性为null  
	    public static final <T> T getObject(String jsontext, Class<T> clazz) {  
	        T t = null;  
	        try {  
	            t = JSON.parseObject(jsontext, clazz);  
	        } catch (Exception e) {  
	        }  
	        return t;  
	    }  
	  
	    public static final String toJSONString(Object object, boolean prettyFormat) {  
	        return JSON.toJSONString(object, prettyFormat);  
	    }  
	  
	    /**  
	     * @Description： json字符串转成为List  
	     * @author: GuXiYang  
	     * @date: 2017/05/08 10:25:00  
	     * @param jsonStr  
	     *            json字符串  
	     * @param clazz  
	     *            class名称  
	     * @return  
	     */  
	    public static <T> List<T> getList(String jsonStr, Class<T> clazz) {  
	        List<T> list = new ArrayList<T>();  
	        try {  
	            list = JSON.parseArray(jsonStr, clazz);  
	        } catch (Exception e) {  
	        }  
	        return list;  
	    }  
	  
	    /**  
	     *   
	     * @Description： json字符串转换成list<Map>  
	     * @author: GuXiYang  
	     * @date: 2017/05/08 10:27:16  
	     * @param jsonString  
	     *            json字符串  
	     * @return  
	     */  
	    public static List<Map<String, Object>> listKeyMaps(String jsonString) {  
	        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
	        try {  
	            list = JSON.parseObject(jsonString,  
	                    new TypeReference<List<Map<String, Object>>>() {  
	            });  
	        } catch (Exception e) {  
	        }  
	        return list;  
	    }  
	  
	    /**  
	     * @Description： json字符串转换为Map  
	     * @author: GuXiYang  
	     * @date: 2017/05/08 10:32:33  
	     * @param jsonStr  
	     *            json字符串  
	     * @return  
	     */  
	    public static Map<String, Object> json2Map(String jsonStr) {  
	        try {  
	            return JSON.parseObject(jsonStr, Map.class);  
	        } catch (Exception e) {  
	        }  
	        return null;  
	    }  
	    
	    public static String Object2JsonString(Object obj) {  
	    	try {  
	    		return JSON.toJSONString(obj);
	    	} catch (Exception e) {  
	    	}  
	    	return null;  
	    }  
	    
	    
	  
}
