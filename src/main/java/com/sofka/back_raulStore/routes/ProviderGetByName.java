package com.sofka.back_raulStore.routes;

import com.sofka.back_raulStore.useCase.ProviderFindByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProviderGetByName {

    @Bean
    public RouterFunction<ServerResponse> GetOneProvider(ProviderFindByIdUseCase getOne){
      return route(GET("/api/provider/{id}"),
              request -> getOne.getProviderById(id))
    }
}
