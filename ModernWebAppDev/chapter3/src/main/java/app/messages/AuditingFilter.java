package app.messages;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class AuditingFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start =new Date().getTime();
		
		//chain.doFilter() 호출을 잊어버리면 클라이언트에 어떠한 응답도 보내지 못함.
		chain.doFilter(request, response);
		long elapsed = new Date().getTime() - start;
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		logger.debug("Request[uri="+req.getRequestURI()+", method="+req.getMethod()+"] completed in "+elapsed+" ms");
	}

}
