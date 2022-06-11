package com.sofka.back_raulStore.routes.bill;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.useCase.bill.BillCreateUseCase;
import com.sofka.back_raulStore.useCase.bill.BillGetAllUseCase;
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
    public RouterFunction<ServerResponse> getAllBills(BillGetAllUseCase getBills){
        return route(GET("/api/bills"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getBills.getBills(), BillDto.class)));
    }
}
