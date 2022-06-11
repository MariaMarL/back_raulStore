package com.sofka.back_raulStore.routes.providerInvoice;

import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.useCase.providerInvoice.CreateProviderInvoiceUseCase;
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
public class CreateProviderInvoiceRoute {

    @Bean
    public RouterFunction<ServerResponse> createProviderInvoice(CreateProviderInvoiceUseCase createProviderInvoiceUseCase){
        return route(POST("/api/providerInvoice/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderInvoiceDto.class)
                        .flatMap(createProviderInvoiceUseCase::createProviderInvoice)
                        .flatMap(providerInvoiceDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerInvoiceDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable);
                            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
                        }));
    }

}
