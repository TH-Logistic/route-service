package com.thlogistic.route.config;

import com.thlogistic.route.interceptor.AuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
@RequiredArgsConstructor
public class AuthenticationAppConfig extends WebMvcConfigurationSupport {

    private final AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor);
    }
}