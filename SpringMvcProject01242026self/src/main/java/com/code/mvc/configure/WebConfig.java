package com.code.mvc.configure;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.code.mvc.component.AdminInterceptor;

public class WebConfig implements WebMvcConfigurer {
	private final AdminInterceptor adminInterceptor;
	@Autowired
	public WebConfig(AdminInterceptor adminInterceptor) {
		this.adminInterceptor=adminInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("error");
		// the AdminInterceptor will check the included paths below and excluded some paths
		registry.addInterceptor(adminInterceptor)
		    .addPathPatterns("/admin/**")
		    .excludePathPatterns(
		    		"/admin/login",
		    		"/admin/login/",
		    		"/admin/authentication",
		    		"/admin/users/registration",
		    		"/admin/logout",
		    		"/css/**", "/js/**", "/images/**");
		
	}
	

}
