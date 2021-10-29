package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@AllArgsConstructor
public class Endpoint {

    private HttpMethod httpMethod;
    private String value;

    public boolean isEquals(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();

        return requestURI.equals(value) && method.equals(this.httpMethod.name());
    }
}
