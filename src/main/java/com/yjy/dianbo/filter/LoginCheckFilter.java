package com.yjy.dianbo.filter;

import com.alibaba.fastjson.JSON;
import com.yjy.dianbo.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        String[] url = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        boolean check = check(url, requestURI);
        if (check) {
            filterChain.doFilter(request, response);
            return;
        }
        if(request.getSession().getAttribute("employee")!=null) {
            filterChain.doFilter(request, response);
            return;
        };
        response.getWriter().write((JSON.toJSONString(R.error("NOTLOGIN"))));
    }

    public boolean check(String[] urls, String requestURL) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURL);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
