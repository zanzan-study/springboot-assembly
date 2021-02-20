package com.huangfu.assembly.interception.config;

import com.huangfu.assembly.interception.interceptions.MyInterceptionOne;
import com.huangfu.assembly.interception.interceptions.MyInterceptionTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * web拦截器配置
 *
 * @author huangfu
 * @date 2021年2月20日11:29:34
 */
@Configuration
@EnableWebMvc
public class InterceptionWebMvc implements WebMvcConfigurer {
    /**
     * 指定字符编码集
     *
     * @return 字符转换器
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截全部的请求
        registry.addInterceptor(new MyInterceptionOne()).addPathPatterns("/**").excludePathPatterns("/favicon.ico");
        //拦截前缀为huangfu的请求  huangfu也算
        registry.addInterceptor(new MyInterceptionTwo()).addPathPatterns("/huangfu/**").excludePathPatterns("/favicon.ico");
    }

    /**
     * 添加字符转换器
     *
     * @param converters 全部的转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }
}
