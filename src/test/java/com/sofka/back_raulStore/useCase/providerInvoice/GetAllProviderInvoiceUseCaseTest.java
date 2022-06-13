package com.sofka.back_raulStore.useCase.providerInvoice;

import com.sofka.back_raulStore.collections.ProviderInvoice;
import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.mapper.ProviderInvoiceMapper;
import com.sofka.back_raulStore.repository.ProviderInvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProviderInvoiceUseCaseTest {

    private GetAllProviderInvoiceUseCase useCase;
    @Autowired
    private ProviderInvoiceMapper mapper;
    @Mock
    ProviderInvoiceRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllProviderInvoiceUseCase(repository, mapper);
    }

    @Test
    void getAllProvInvoice(){
        ProviderInvoice providerInvoice1 = new ProviderInvoice();

        providerInvoice1.setId("1");
        providerInvoice1.setProductId("OP1212AS4454A");
        providerInvoice1.setDate("13-06-2022");
        providerInvoice1.setProviderId("ASS3433443");
        providerInvoice1.setAmount(15);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(providerInvoice1));
        Flux<ProviderInvoiceDto> receiptDTOFlux = useCase.getAllProviderInvoice();

        StepVerifier.create(receiptDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();

    }


}