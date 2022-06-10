package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductGetByIdUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDto> getProductById(String id){

        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(()-> new IllegalStateException("Product not found. ID: "+ id)))
                .map(productMapper::toProductDto);
    }
}
