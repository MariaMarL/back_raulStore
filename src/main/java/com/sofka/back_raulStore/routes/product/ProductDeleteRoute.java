package com.sofka.back_raulStore.routes.product;

import com.sofka.back_raulStore.useCase.produc.ProductDeleteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductDeleteRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteProduct (ProductDeleteUseCase deleteProduct){
        return route(DELETE("/api/product/delete/{id}"),
                request -> deleteProduct.delete(request.pathVariable("id"))
                        .flatMap((x) -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(throwable -> {
                            System.out.println(throwable.getMessage());
                            return ServerResponse.status(HttpStatus.NOT_FOUND).build();
                        }));
    }
}
