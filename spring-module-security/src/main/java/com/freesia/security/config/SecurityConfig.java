package com.freesia.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import javax.annotation.Resource;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-12 14:55
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthFilter authFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/security/**")
                .addFilterBefore(authFilter, LogoutFilter.class)
                .authorizeRequests()
                .antMatchers("/security/api/v1/noAuth/**").permitAll()
                .anyRequest().authenticated();
    }
}
