package com.sofka.back_raulStore.useCase.produc;

import com.sofka.back_raulStore.dto.ProductDto;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ProductGetAllUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Flux<ProductDto> getProducts(){
        return productRepository.findAll().map(productMapper::toProductDto);
        //return productRepository.findAll().map(product -> productMapper.toProductDto(product));
    }
}
