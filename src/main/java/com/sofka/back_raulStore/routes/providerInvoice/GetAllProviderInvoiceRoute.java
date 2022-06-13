package com.sofka.back_raulStore.routes.providerInvoice;

import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.useCase.providerInvoice.GetAllProviderInvoiceUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "Get all provider invoices", operationId = "providerInvoice", tags = "providerInvoices",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProviderInvoiceDto.class)))))

    public RouterFunction<ServerResponse> allProviderInvoice(GetAllProviderInvoiceUseCase getAllProviderInvoiceUseCase){
        return route(GET("/api/providerInvoices"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getAllProviderInvoiceUseCase.getAllProviderInvoice(), ProviderInvoiceDto.class)));
    }
}
