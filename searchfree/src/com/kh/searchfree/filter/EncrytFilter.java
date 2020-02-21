package com.kh.searchfree.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.searchfree.wrapper.EncryptWrapper;

@WebFilter(urlPatterns= {"/member/login.do",
						"/member/signUp.do",
						"/member/updatePwd.do",
						"/member/deleteMember.do"})
public class EncrytFilter implements Filter {
    public EncrytFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest h_request = (HttpServletRequest)request;
		
		// Encrypt Wrapper  (요청객체 자체를 새로운 객체(Wrapper)로 변환하여 대체
		
		// Encrypt Wrapper 객체생성
		EncryptWrapper encWrapper = new EncryptWrapper(h_request);
		
		chain.doFilter(encWrapper, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
