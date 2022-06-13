package com.sofka.back_raulStore.routes.provider;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.useCase.provider.ProviderCreateUseCase;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProviderCreateRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Create product", operationId = "provider", tags = "providers",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProviderDto.class)))))

    public RouterFunction<ServerResponse> createProvider(ProviderCreateUseCase create){
        return route(POST("/api/provider/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDto.class)
                        .flatMap(create::create)
                        .flatMap(providerDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDto))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }

}
