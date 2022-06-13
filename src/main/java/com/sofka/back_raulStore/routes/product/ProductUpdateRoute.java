package com.sofka.back_raulStore.routes.product;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.useCase.produc.ProductUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductUpdateRoute {

    @Bean
    public RouterFunction<ServerResponse> updateProduct (ProductUpdateUseCase updateProduct){
        return route(PUT("/api/product/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(updateProduct::updateProduct)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
                        }));
    }
}
