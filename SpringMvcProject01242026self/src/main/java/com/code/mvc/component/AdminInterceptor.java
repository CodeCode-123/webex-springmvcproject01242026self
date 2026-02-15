package com.code.mvc.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response,
			                 Object handler) throws Exception {
		String uri = request.getRequestURI();           // e.g. /SpringMVCProject01242026/admin/category
		String contextPath = request.getContextPath();  // e.g. /SpringMVCProject01242026
		String path = uri.substring(contextPath.length()); // e.g. /admin/category
		System.out.println("REQUEST URI: " + uri + " | PATH: " + path);
		// 1) If it's NOT under /admin, let it pass (this fixes / and any public URLs)
		if (!path.startsWith("/admin")) {
			return true;
		}
		// 2) Allow login/auth URLs to pass without session check
		if (path.equals("/admin/login") || 
			path.equals("/admin/login/") ||
			path.equals("/admin/authentication") ||
			path.equals("/admin/registration") ||
			path.equals("/admin/save1") ||
			path.equals("/admin/logout")) {
			return true;
		}
		// 3) Now check the session
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("adminusers") != null) {
			return true;
		}
		// 4) Not logged in -> redirect to admin login 
		// if not the URIs above, redirect to /admin/login, only path?
		response.sendRedirect(contextPath + "/admin/login");
		return false;
	}
}
