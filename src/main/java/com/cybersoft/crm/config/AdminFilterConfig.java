package com.cybersoft.crm.config;

import com.cybersoft.crm.filters.AdminFilter;
import com.cybersoft.crm.filters.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminFilterConfig {
    @Bean
    public FilterRegistrationBean<AdminFilter> AdminFilterConfig()
    {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/role/table");
        registrationBean.addUrlPatterns("/role/changeInfo/*");

        return registrationBean;
    }
}
