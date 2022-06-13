package com.sofka.back_raulStore.useCase.providerInvoice;

import com.sofka.back_raulStore.collections.ProviderInvoice;
import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreateProviderInvoiceUseCaseTest {

    @MockBean
    CreateProviderInvoiceUseCase useCase;

    @Test
    void saveProvInvoice(){

        ProviderInvoiceDto providerInvoiceDto = new ProviderInvoiceDto();

        providerInvoiceDto.setId("1");
        providerInvoiceDto.setProductId("OP1212AS4454A");
        providerInvoiceDto.setDate("13-06-2022");
        providerInvoiceDto.setProviderId("ASS3433443");
        providerInvoiceDto.setAmount(15);

        StepVerifier.create(Mono.just(Mockito.when(useCase.createProviderInvoice(providerInvoiceDto))
                        .thenReturn(Mono.just(providerInvoiceDto)))).expectNextCount(1).expectComplete().verify();


    }
}