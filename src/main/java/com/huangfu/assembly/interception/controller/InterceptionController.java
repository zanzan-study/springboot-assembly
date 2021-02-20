package com.huangfu.assembly.interception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器控制器
 *
 * @author huangfu
 * @date 2021年2月20日11:32:30
 */

@RestController
public class InterceptionController {

    @RequestMapping("allInterception")
    public String allInterception() {
        return "触发全部的拦截器";
    }

    @RequestMapping("huangfu")
    public String huangfuInterception() {
        return "触发huangfu路径的拦截器";
    }
}
