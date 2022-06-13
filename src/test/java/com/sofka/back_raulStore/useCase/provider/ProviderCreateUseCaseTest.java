package com.sofka.back_raulStore.useCase.provider;

import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.useCase.produc.ProductCreateUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProviderCreateUseCaseTest {

    @MockBean
    ProviderCreateUseCase useCase;

    @Test
    void saveProvider(){
        ProviderDto providerDto = new ProviderDto();

        providerDto.setId("2");
        providerDto.setName("Maria");
        providerDto.setDni("43323444");
        providerDto.setPhone("3123214567");

        StepVerifier.create(Mono.just(Mockito.when(useCase.create(providerDto))
                .thenReturn(Mono.just(providerDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}