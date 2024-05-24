package com.cybersoft.crm.config;

import com.cybersoft.crm.filters.LoginFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginFilterConfig {
    @Bean
    public FilterRegistrationBean<LoginFilter> filterConfig()
    {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/login");

        return registrationBean;
    }
}
