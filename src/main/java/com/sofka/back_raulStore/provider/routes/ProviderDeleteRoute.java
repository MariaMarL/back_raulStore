package com.sofka.back_raulStore.provider.routes;

import com.sofka.back_raulStore.provider.useCase.ProviderDeleteUseCase;
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
        return route(DELETE("/api/provider/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProvider.delete(request.pathVariable("id"))
                        .flatMap((unused) -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }

}
