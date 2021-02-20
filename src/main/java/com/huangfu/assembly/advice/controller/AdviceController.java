package com.huangfu.assembly.advice.controller;

import com.huangfu.assembly.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器控制器
 *
 * @author huangfu
 * @date 2021年2月20日11:32:30
 */

@RestController
public class AdviceController {

    @RequestMapping("all")
    public String all() {
        return "触发请求包装";
    }

    @RequestMapping("user")
    public User user() {
        return new User("huangfu","男");
    }

}
