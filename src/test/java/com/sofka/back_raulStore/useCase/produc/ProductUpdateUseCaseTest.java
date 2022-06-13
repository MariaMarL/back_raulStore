package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductUpdateUseCaseTest {


    @MockBean
    ProductUpdateUseCase useCase;

    @Test
    void productUpdated(){

        ProductDto productDto = new ProductDto();

        productDto.setId("2");
        productDto.setName("Maria");
        productDto.setDescription("Description");
        productDto.setUnitsLeft(2);
        productDto.setMaxUnits(50);
        productDto.setMinUnits(3);
        productDto.setPrice(50000.00);
        productDto.setProviderName("Juana");

        StepVerifier.create(Mono.just(Mockito.when(useCase.updateProduct(productDto))
                .thenReturn(Mono.just(productDto)))).expectNextCount(1).expectComplete().verify();
    }


}