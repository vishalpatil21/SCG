package com.microservice.SCG.filter.gatewayfilter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomLoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomLoggingGatewayFilterFactory.Config> {

    public CustomLoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Get request method and URI
            String method = exchange.getRequest().getMethod().name();
            String uri = exchange.getRequest().getURI().toString();

            // Print method and URI
            System.out.println("Request Method: " + method);
            System.out.println("Request URI: " + uri);

            // Proceed with the filter chain
            return chain.filter(exchange);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList();
    }

    public static class Config {
        // No configuration needed for this filter
    }
}
