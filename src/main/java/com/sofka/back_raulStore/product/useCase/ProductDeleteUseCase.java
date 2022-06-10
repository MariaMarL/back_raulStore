package com.sofka.back_raulStore.product.useCase;

import com.sofka.back_raulStore.product.mapper.ProductMapper;
import com.sofka.back_raulStore.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
