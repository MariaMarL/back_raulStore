package com.sofka.back_raulStore.routes.bill;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.useCase.bill.BillCreateUseCase;
import com.sofka.back_raulStore.useCase.bill.BillGetAllUseCase;
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
public class BillGetAllRoute {

    @Bean

    @RouterOperation(operation = @Operation(description = "Create Bill", operationId = "bills", tags = "Bills",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BillDto.class)))))


    public RouterFunction<ServerResponse> getAllBills(BillGetAllUseCase getBills){
        return route(GET("/api/bills"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getBills.getBills(), BillDto.class)));
    }
}
