package com.example.gatewayservice.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/*
 *  @author diemdz
 */
@Component
public class RouteValidator {
    public static final List<String> openApiEndpoints = List.of(
            "/auth/registry",
            "/auth/login",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
