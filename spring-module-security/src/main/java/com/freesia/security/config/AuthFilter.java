package com.freesia.security.config;

import com.freesia.security.model.User;
import com.freesia.security.service.LoadUserServiceImpl;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-12 17:53
 **/
@Component
public class AuthFilter extends OncePerRequestFilter {

    @Resource
    private LoadUserServiceImpl loadUserService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String uri = httpServletRequest.getRequestURI();
        if (!StringUtils.isEmpty(uri)) {
            //默认的传参暂时用不上
            User userDetails = loadUserService.loadUserByUsername(null);
            //获取要访问的接口，检查用户是否有权限
            if (userDetails != null && userDetails.isEnabled() && userDetails.access(uri)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null, userDetails.getAuthorities());
                // 把当前登陆用户放到上下文中
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                // 用户不合法，清除上下文
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
