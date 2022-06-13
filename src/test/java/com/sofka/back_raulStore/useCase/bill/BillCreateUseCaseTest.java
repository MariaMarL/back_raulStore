package com.sofka.back_raulStore.useCase.bill;

import com.sofka.back_raulStore.dto.BillDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillCreateUseCaseTest {

    @MockBean
    BillCreateUseCase useCase;

    @Test
    void billToCreate(){

        BillDto billDto = new BillDto();

        List<String> products = new ArrayList<>();
        products.add("ProductId1");
        products.add("ProductId2");


        billDto.setId("1");
        billDto.setDate("12-06-2022");
        billDto.setClientName("Maria");
        billDto.setSellerName("David");
        billDto.setProductId(products);
        billDto.setTotal(34500.00);

        StepVerifier.create(Mono.just(Mockito.when(useCase.createBill(billDto))
                .thenReturn(Mono.just(billDto)))).expectNextCount(1)
                .expectComplete()
                .verify();

    }

}