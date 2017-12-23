package com.codegen.util.security;

import com.codegen.service.util.TokenAuthService;
import com.codegen.service.util.TokenAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class StatelessAuthFilter extends GenericFilterBean {

    @Autowired
    TokenAuthService tokenAuthService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(tokenAuthService.
                getAuthentication((HttpServletRequest) servletRequest).orElse(null));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
