package main.java.thecrud.backend.auth;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.thecrud.backend.SessionContext;

@WebFilter(urlPatterns = { "/session/*" })
public class AuthenticationFilter implements Filter {

    @Inject
    private SessionContext sessionContext;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain filterChain) throws IOException, ServletException {
	
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	
	if (sessionContext.getLoggedUser() == null && (httpServletRequest.getPathInfo() == null || !httpServletRequest.getPathInfo().contains("/user/login"))) {
	    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	    httpServletResponse.sendRedirect("/thecrud/login.html");
	} else {
	    filterChain.doFilter(request, response);
	}
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
