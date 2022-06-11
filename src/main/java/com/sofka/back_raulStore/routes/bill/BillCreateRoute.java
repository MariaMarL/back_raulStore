package com.sofka.back_raulStore.routes.bill;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.useCase.bill.BillCreateUseCase;
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
public class BillCreateRoute {

    @Bean
    public RouterFunction<ServerResponse> createBill (BillCreateUseCase createBill){
        return route(POST("/api/bill/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDto.class)
                        .flatMap(createBill::createBill)
                        .flatMap(billDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(billDto))
                        .onErrorResume(throwable -> {
                            System.out.println(throwable);
                            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
                        }));
    }
}
