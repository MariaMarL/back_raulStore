package com.sofka.back_raulStore.collections;

import com.sofka.back_raulStore.dto.ProviderDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer unitsLeft;
    private Integer maxUnits;
    private Integer minUnits;
    private Double price;
    private String providerName;

}
