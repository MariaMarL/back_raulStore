package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.collections.Product;
import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.ProductRepository;
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
class ProductGetAllUseCaseTest {

    private ProductGetAllUseCase useCase;

    @Autowired
    ProductMapper mapper;
    @Mock
    ProductRepository repository;

    @BeforeEach
    void setUp(){
        useCase = new ProductGetAllUseCase(repository,mapper);

    }

    @Test
    void getAllProducts(){

        Product product = new Product();
        product.setId("2");
        product.setName("Maria");
        product.setDescription("Description");
        product.setUnitsLeft(2);
        product.setMaxUnits(50);
        product.setMinUnits(3);
        product.setPrice(50000.00);
        product.setProviderName("Juana");

        Mockito.when(repository.findAll())
                .thenReturn(Flux.just(product));
        Flux<ProductDto> productDtoFlux = useCase.getProducts();

        StepVerifier.create(productDtoFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}