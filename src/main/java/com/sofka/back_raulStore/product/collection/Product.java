package com.sofka.back_raulStore.product.collection;

import com.sofka.back_raulStore.provider.collections.Provider;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    private Integer unitsLeft;
    private Integer maxUnits;
    private Integer minUnits;

    @NotBlank
    private Double price;

    private Provider provider;

}
