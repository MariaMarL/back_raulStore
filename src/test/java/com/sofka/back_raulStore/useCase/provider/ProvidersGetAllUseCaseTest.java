package com.sofka.back_raulStore.useCase.provider;

import com.sofka.back_raulStore.collections.Provider;
import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.mapper.ProviderMapper;
import com.sofka.back_raulStore.repository.ProviderRepository;
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
class ProvidersGetAllUseCaseTest {

    private ProvidersGetAllUseCase useCase;
    @Autowired
    private ProviderMapper mapper;
    @Mock
    ProviderRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new ProvidersGetAllUseCase(repository, mapper);
    }

    @Test
    void gellProviders(){
        Provider provider1 = new Provider();

        provider1.setId("2");
        provider1.setName("Maria");
        provider1.setDni("43323444");
        provider1.setPhone("3123214567");

        Provider provider2 = new Provider();

        provider2.setId("3");
        provider2.setName("Camilo");
        provider2.setDni("67823444");
        provider2.setPhone("3003214567");

        Mockito.when(repository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDto> providerDTOFlux = useCase.getProviders();

        StepVerifier.create(providerDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
    
    
}