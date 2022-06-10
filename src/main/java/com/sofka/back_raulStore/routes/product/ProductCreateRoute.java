package com.sofka.back_raulStore.routes.product;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.useCase.produc.ProductCreateUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductCreateRoute {

    @Bean
    public RouterFunction<ServerResponse> createProduct(ProductCreateUseCase createProduct){
        return route(POST("/api/product/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(createProduct::createProduct)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();

                                }
                        ));
    }
}
