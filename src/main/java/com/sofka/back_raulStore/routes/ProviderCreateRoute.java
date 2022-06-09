package com.sofka.back_raulStore.routes;

import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.useCase.ProviderCreateUseCase;
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
    public RouterFunction<ServerResponse> createProvider(ProviderCreateUseCase create){
        return route(POST("/api/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDto.class)
                        .flatMap(create::create)
                        .flatMap(providerDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDto))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }

}
