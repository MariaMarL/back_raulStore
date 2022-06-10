package com.sofka.back_raulStore.routes.provider;

import com.sofka.back_raulStore.useCase.provider.ProviderDeleteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProviderDeleteRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteProvider (ProviderDeleteUseCase deleteProvider){
        return route(DELETE("/api/provider/delete/{id}"),
                request -> deleteProvider.delete(request.pathVariable("id"))
                        .flatMap((unused) -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }

}
