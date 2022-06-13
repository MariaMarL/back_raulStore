package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
public class ProductUpdateUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDto> updateProduct(@Valid ProductDto productDto){
        return productRepository.save(productMapper.toProductEntity(productDto))
                .map(productMapper::toProductDto);
    }
}
