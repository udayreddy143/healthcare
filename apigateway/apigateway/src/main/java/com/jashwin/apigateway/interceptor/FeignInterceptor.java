package com.jashwin.apigateway.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {

        System.out.println("hey i am exceuting"+requestTemplate.url());

        // Add Authorization header to all requests
    }
}
