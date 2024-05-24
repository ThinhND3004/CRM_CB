package com.cybersoft.crm.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        boolean checkRole = false;


        for(Cookie cookie : cookies)
        {
            if("role".equals(cookie.getName()) && cookie.getValue().equals("ROLE_ADMIN"))
            {
                checkRole = true;
                break;
            }
//            if(cookie.getAttribute("role") != null &&
//                    cookie.getAttribute("role").equals("ROLE_ADMIN"))
//            {
//                filterChain.doFilter(servletRequest,servletResponse);
//                break;
//            } else
//            {
//
//                response.sendRedirect(request.getContextPath() + "/index");
//                break;
//            }
        }

        if(checkRole)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            response.sendRedirect(request.getContextPath() + "/index");
    }
}
