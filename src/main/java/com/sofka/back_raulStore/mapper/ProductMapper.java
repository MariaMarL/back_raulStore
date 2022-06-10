package com.sofka.back_raulStore.mapper;

import com.sofka.back_raulStore.collections.Product;
import com.sofka.back_raulStore.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProductMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ProductDto toProductDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }

    public Product toProductEntity (ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }
}
