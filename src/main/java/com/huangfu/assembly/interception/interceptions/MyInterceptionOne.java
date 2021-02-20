package com.huangfu.assembly.interception.interceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Spring拦截器实现
 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html 第1.1.6章节
 *
 * @author huangfu
 * @date 2021年2月20日11:16:45
 */
@Slf4j
public class MyInterceptionOne implements HandlerInterceptor {
    /**
     * 在实际的处理程序运行之前
     * 方法返回一个布尔值。您可以使用此方法来中断或继续执行链的处理。
     * 当此方法返回时true，处理程序执行链继续。
     * 当它返回false时，DispatcherServlet 假定拦截器本身已经处理了请求（例如，渲染了适当的视图），并且不会继续执行其他拦截器和执行链中的实际处理程序。
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return 是否拒绝处理
     * @throws Exception 异常信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.warn("---------前置拦截器: 1-----------");
        return true;
    }

    /**
     * 请注意，postHandle使用@ResponseBody和ResponseEntity方法在HandlerAdapterand之前 编写和提交响应的方法用处不大postHandle。
     * 这意味着对响应进行任何更改为时已晚，例如添加额外的请求头。
     *
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     * @throws Exception Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.warn("---------后置拦截器: 1-----------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.warn("---------完成后的拦截器: 1-----------");
    }
}
