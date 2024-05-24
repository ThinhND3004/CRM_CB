package com.cybersoft.crm.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        boolean hasEmailCookie = false;

        for (Cookie cookie : cookies) {
            if ("email".equals(cookie.getName()) && cookie.getValue() != null) {
                hasEmailCookie = true;
                break;
            }
        }

        if (hasEmailCookie) {
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
