package com.sofka.back_raulStore.routes.provider;

import com.sofka.back_raulStore.useCase.provider.ProviderFindByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProviderGetByIdRoute {

    @Bean
    public RouterFunction<ServerResponse> GetOneProvider(ProviderFindByIdUseCase getOne){
      return route(GET("/api/provider/{id}"),
              request -> getOne.getProviderById(request.pathVariable("id"))
                      .flatMap(providerDto -> ServerResponse.status(HttpStatus.OK)
                              .contentType(MediaType.APPLICATION_JSON)
                              .bodyValue(providerDto))
                      .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }
}
