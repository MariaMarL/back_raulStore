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
    @NotBlank(message = "This space can't be empty")
    private String name;
    @NotBlank(message = "This space can't be empty")
    private String description;
    @NotBlank(message = "This space can't be empty")
    private Integer unitsLeft=0;
    @NotBlank(message = "This space can't be empty")
    private Integer maxUnits;
    @NotBlank(message = "This space can't be empty")
    private Integer minUnits;
    @NotBlank(message = "This space can't be empty")
    private Double price;
    @NotBlank(message = "This space can't be empty")
    private String providerName;

}
