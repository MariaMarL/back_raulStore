package com.sofka.back_raulStore.routes.provider;

import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.useCase.provider.ProvidersGetAllUseCase;
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
public class ProviderGetAllRoute {

    @Bean
    public RouterFunction<ServerResponse> allProvidersRoute(ProvidersGetAllUseCase providersGetAll){
       return  route(GET("/api/providers"),
               request -> ServerResponse.status(HttpStatus.OK)
                       .contentType(MediaType.APPLICATION_JSON)
                       //.body(BodyInserters.fromProducer(providersGetAll.getProviders(), ProviderDto.class)));
                       .body(BodyInserters.fromProducer(providersGetAll.getProviders(), ProviderDto.class)));
    }
}
