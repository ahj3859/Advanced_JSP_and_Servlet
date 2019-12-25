package com.multi.biz.A01_Filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// Annotation을 사용하면 web.xml에 기술하지 않는다.
// 서블릿 컨테이너는 이 이름으로 해당 클래스를 알아서 연결한다.
@WebFilter(filterName = "/UserCheckFilter", urlPatterns = "*")
public class UserCheckFilter implements Filter {

	// 외부에 저장할 파일 객체
	PrintWriter pw = null;

	public void init(FilterConfig fConfig) throws ServletException {
		GregorianCalendar now = new GregorianCalendar();
		
		String fileName = now.get(Calendar.YEAR) + "_" + (now.get(Calendar.MONTH) + 1) + "_" + now.get(Calendar.DATE);
		try {
			FileWriter fw = new FileWriter("d:\\workspace\\Chap04_MyBatis\\" + fileName + ".log", true);
			pw = new PrintWriter(fw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		GregorianCalendar now = new GregorianCalendar();
		String address = request.getRemoteAddr();
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		pw.printf("[%TF %TT] - %s - %s %n", now, now, address, uri);
		pw.flush();
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		if (pw != null) {
			pw.close();
		}
	}
}
