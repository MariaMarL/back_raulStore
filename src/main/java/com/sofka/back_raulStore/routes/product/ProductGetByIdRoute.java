package com.sofka.back_raulStore.routes.product;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.useCase.produc.ProductGetByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductGetByIdRoute {

    @Bean
    public RouterFunction<ServerResponse> GetOneProduct(ProductGetByIdUseCase getProduct){
        return route(GET("/api/product/{id}"),
                request -> getProduct.getProductById(request.pathVariable("id"))
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.NOT_FOUND).build();

                        }));
    }
}
