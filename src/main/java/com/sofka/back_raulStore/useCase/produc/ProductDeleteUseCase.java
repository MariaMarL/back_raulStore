package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Validated
public class ProductDeleteUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<Void> delete (String id){
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(()->new IllegalStateException("Product not found. id: "+id)))
                .flatMap(product -> productRepository.deleteById(product.getId()));

    }
}
