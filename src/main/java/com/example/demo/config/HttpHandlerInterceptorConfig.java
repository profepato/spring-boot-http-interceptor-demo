package com.example.demo.config;

import com.example.demo.model.Endpoint;
import com.example.demo.model.exceptions.NotAllowedHttpMethodException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class HttpHandlerInterceptorConfig implements HandlerInterceptor {

    private final List<Endpoint> allowedEndpoints;

    public HttpHandlerInterceptorConfig() {
        allowedEndpoints = new ArrayList<>();

        String test = "/test";

        allowedEndpoints.add(new Endpoint(HttpMethod.POST, test));
        allowedEndpoints.add(new Endpoint(HttpMethod.GET, test));
        allowedEndpoints.add(new Endpoint(HttpMethod.PUT, "/test2"));
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object handler) throws NotAllowedHttpMethodException {
        if (isAllowedEndpoint(httpServletRequest)) {
            return true;
        }

        throw new NotAllowedHttpMethodException("Error, method not allowed");
    }

    public boolean isAllowedEndpoint(HttpServletRequest httpServletRequest) {
        for (Endpoint endpoint : allowedEndpoints) {
            if (endpoint.isEquals(httpServletRequest)){
                return true;
            }
        }

        return false;
    }
}
