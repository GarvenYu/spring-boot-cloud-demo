package com.freesia.security.service;

import com.freesia.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-12 15:47
 * 实现加载用户角色的方法
 **/
@Service
public class LoadUserServiceImpl implements UserDetailsService {
    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        //mock 从数据库或者缓存中查询用户的角色和功能
        User user = new User();
        user.setAccessUrl(Arrays.asList("/xxxx","/xxxxxxx"));
        return user;
    }
}
