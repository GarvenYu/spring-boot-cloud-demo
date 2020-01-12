package com.freesia.security.controller;

import com.freesia.security.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-12 14:31
 **/
@RestController
@RequestMapping(value = "/security/api/v1")
public class TestController {

    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(){
        return "Login User Info";
    }

    @GetMapping(value = "/noAuth/getUserInfo")
    public String noAuthGetUserInfo(){
        return "Anonymous User Info";
    }
}
