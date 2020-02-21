package com.kh.searchfree.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


// filterName : 필터의 이름지정(필터순서지정시 사용)
// urlPatterns : 필터가 적용될 url 패턴 지정(/* : 모든 url)
@WebFilter(filterName="encoding", urlPatterns = "/*")
public class CommonFilter implements Filter {
	// implements Filter 라는 interface상속 받으며, 서버에서 생성
	/* Filter는 request, response가 Servlet / JSP 또는 클라이언트 에게 도달하기 전에 
	 * 필요한 전/후 처리 작업을 맡는 클래스( FilterChain 을 통해 여러 필터 사용 가능)
	 * 
	 * Filter의 생명주기
	 * init() -> doFilter() -> destroy() 
	 * 서버시작        필터링 내용           변경/수정시 파괴
	 * 
	 * Filter 등록 방법
	 * 1. web.xml에 등록
	 * 2. @WebFilter 어노테이션 사용(Servlet 3.0이상)
	 * 		-> tomcat 8.5v == servlet 3.1v
	 * */
    public CommonFilter() {
    	
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		String uri = ((HttpServletRequest)request).getRequestURI();
        
	      if(!uri.substring(uri.lastIndexOf(".")+1).equals("css")) {
	         response.setContentType("text/html; charset=UTF-8");
	      }
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
