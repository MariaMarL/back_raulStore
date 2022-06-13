package com.sofka.back_raulStore.routes.provider;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.useCase.provider.ProviderFindByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "Get one product created", operationId = "provider", tags = "providers",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProviderDto.class)))))

    public RouterFunction<ServerResponse> GetOneProvider(ProviderFindByIdUseCase getOne){
      return route(GET("/api/provider/{id}"),
              request -> getOne.getProviderById(request.pathVariable("id"))
                      .flatMap(providerDto -> ServerResponse.status(HttpStatus.OK)
                              .contentType(MediaType.APPLICATION_JSON)
                              .bodyValue(providerDto))
                      .onErrorResume(throwable -> {
                                System.out.println(throwable.getMessage());
                              return ServerResponse.status(HttpStatus.NOT_FOUND).build();
                      }
                      ));
    }
}
