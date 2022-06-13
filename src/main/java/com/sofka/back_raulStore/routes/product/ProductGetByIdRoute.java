package com.sofka.back_raulStore.routes.product;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.useCase.produc.ProductGetByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "Get One product created", operationId = "product", tags = "products",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDto.class)))))

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
