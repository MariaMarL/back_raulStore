package com.sofka.back_raulStore.useCase.bill;

import com.sofka.back_raulStore.collections.Bill;
import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.mapper.BillMapper;
import com.sofka.back_raulStore.repository.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillGetAllUseCaseTest {

    private  BillGetAllUseCase useCase;

    @Autowired
    private BillMapper mapper;

    @Mock
    BillRepository repository;

    @BeforeEach
    void getAll() {
        useCase = new BillGetAllUseCase(repository,mapper);
    }

    @Test
    void getBills(){

        Bill bill = new Bill();

        List<String> products = new ArrayList<>();
        products.add("ProductId1");
        products.add("ProductId2");


        bill.setId("1");
        bill.setDate("12-06-2022");
        bill.setClientName("Maria");
        bill.setSellerName("David");
        bill.setProductId(products);
        bill.setTotal(34500.00);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(bill));
        Flux<BillDto> billDtoFlux = useCase.getBills();

        StepVerifier.create(billDtoFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();


    }



}