package com.chanzo.apigateway.filter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private final WebClient webClient;

    public JwtValidationGatewayFilterFactory(@Value("${authentication.service.url:http://localhost:8084}")
                                             String authenticationServiceUrl) {
        this.webClient = WebClient.builder().baseUrl(authenticationServiceUrl).build();
    }

     @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain)->{
            String token=
                    exchange.getRequest().getHeaders().getFirst("Authorization");
            if( token==null || !token.startsWith("Bearer ")){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            return webClient.get()
                    .uri("/auth/validate")
                    .header("Authorization", token)
                    .exchangeToMono(response -> {
                        if (response.statusCode().is2xxSuccessful()) {
                            return chain.filter(exchange);
                        }
                        if (response.statusCode().value() == 401 || response.statusCode().value() == 403) {
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return exchange.getResponse().setComplete();
                        }
                        exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
                        return exchange.getResponse().setComplete();
                    })
                    .onErrorResume(ex -> {
                        exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
                        return exchange.getResponse().setComplete();
                    });
        };
    }
}
