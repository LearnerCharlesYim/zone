package com.charles.zone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/article/**").setViewName("detail");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String absolutePath = new File("src\\main\\resources\\static\\upload\\").getAbsolutePath();
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:"+absolutePath + "\\");
    }

}
