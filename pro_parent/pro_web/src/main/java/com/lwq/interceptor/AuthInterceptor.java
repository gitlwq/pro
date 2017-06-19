package com.lwq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lwq.interceptor.annotation.Auth;
/**
 * 
* @ClassName: AuthInterceptor
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年6月19日 上午9:44:54
 */
public class AuthInterceptor  extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		//如果映射的不是方法
		if(!( handler instanceof  HandlerMethod)){
			return true;
			
			
			
		}else{
			HandlerMethod handlerMethod=	 (HandlerMethod) handler;
			
			Auth methodAnnotation = handlerMethod.getMethodAnnotation(Auth.class);
			//没有授权
			if(methodAnnotation==null){
				
				response.getWriter().print("Error");;
				response.getWriter().close();
				return false;
			}else{
				
				System.out.println("授权成功。。。。");
			}
			
			return true;
		}
	}

}
