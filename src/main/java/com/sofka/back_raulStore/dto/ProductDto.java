package com.sofka.back_raulStore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {


    private String id;

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "description can't be blank")
    private String description;

    private Integer unitsLeft;

    @NotNull(message = "Max units can't be null")
    private Integer maxUnits;

    @NotNull(message = "Min units can't be null")
    private Integer minUnits;

    @NotNull(message = "Price can't be null")
    private Double price;

    @NotBlank(message = "Message can't be blank")
    private String providerName;
}
