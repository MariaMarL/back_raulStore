package com.sofka.back_raulStore.product.routes;

import com.sofka.back_raulStore.product.dto.ProductDto;
import com.sofka.back_raulStore.product.useCase.ProductGetAllUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductGetAllRoute {

    @Bean
    public RouterFunction<ServerResponse> allProductsRoute(ProductGetAllUseCase productGetAllUseCase){
        return route(GET("/api/products"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(productGetAllUseCase.getProducts(), ProductDto.class)));
    }
}
