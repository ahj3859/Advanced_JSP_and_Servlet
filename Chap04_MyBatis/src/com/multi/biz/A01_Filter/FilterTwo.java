package com.multi.biz.A01_Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// Annotation을 사용하던 web.xml에 등록하던 1개를 선택해서 설정해야 사용가능
public class FilterTwo implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Fliter Two INIT");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Fliter Two doFilter before");
		chain.doFilter(request, response);
		System.out.println("Fliter Two doFilter after");
	}

	public void destroy() {
		System.out.println("Fliter Two Destory");
	}
}
