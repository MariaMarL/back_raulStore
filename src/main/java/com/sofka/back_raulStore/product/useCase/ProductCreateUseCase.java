package com.sofka.back_raulStore.product.useCase;


import com.sofka.back_raulStore.product.dto.ProductDto;
import com.sofka.back_raulStore.product.mapper.ProductMapper;
import com.sofka.back_raulStore.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
public class ProductCreateUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDto> create(@Valid ProductDto productDto){
        return productRepository.save(productMapper.toProductEntity(productDto))
                .map(productMapper::toProductDto);
    }
}
