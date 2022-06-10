package com.sofka.back_raulStore.product.useCase;

import com.sofka.back_raulStore.product.dto.ProductDto;
import com.sofka.back_raulStore.product.mapper.ProductMapper;
import com.sofka.back_raulStore.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ProductGetAllUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Flux<ProductDto> getProducts(){
        return productRepository.findAll().map(productMapper::toProductDto)
        //return productRepository.findAll().map(product -> productMapper.toProductDto(product))
    }
}
