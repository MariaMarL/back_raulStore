package com.sofka.back_raulStore.routes.providerInvoice;

import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.useCase.providerInvoice.GetAllProviderInvoiceUseCase;
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
public class GetAllProviderInvoiceRoute {

    @Bean
    public RouterFunction<ServerResponse> allProviderInvoice(GetAllProviderInvoiceUseCase getAllProviderInvoiceUseCase){
        return route(GET("/api/ProviderInvoices"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getAllProviderInvoiceUseCase.getAllProviderInvoice(), ProviderInvoiceDto.class)));
    }
}
