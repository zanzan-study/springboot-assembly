package com.huangfu.assembly.advice.advices;

import com.alibaba.fastjson.JSON;
import com.huangfu.assembly.model.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 结果集包装处理器
 *
 * @author huangfu
 * @date 2021年2月20日13:25:58
 */
@RestControllerAdvice
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 是否进行拦截
     *
     * @param returnType    返回值类型
     * @param converterType 选定的转换器类型
     * @return 是否拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 结果集处理器
     * org.springframework.http.converter.StringHttpMessageConverter#writeInternal(java.lang.String, org.springframework.http.HttpOutputMessage)
     * String值必须经过一次json化  因为 这个处理器只接受String类型的参数
     *
     * @param body                  结果
     * @param returnType            控制器方法的返回类型
     * @param selectedContentType   通过内容协商选择的内容类型
     * @param selectedConverterType 选择要写入响应的转换器类型
     * @param request               当前请求
     * @param response              当前的反应
     * @return 传入的正文或经过修改的（可能是新的）实例
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return JSON.toJSONString(ResponseResult.success(body));
        } else if (body instanceof ResponseResult) {
            return body;
        } else {
            return ResponseResult.success(body);
        }

    }
}
