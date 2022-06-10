package com.sofka.back_raulStore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {


    private String id;

    @NotBlank(message = "This space can't be empty")
    private String name;

    @NotBlank(message = "This space can't be empty")
    private String description;

    private Integer unitsLeft;

    @NotNull(message = "Max units can't be null")
    private Integer maxUnits;

    @NotNull(message = "Max units can't be null")
    private Integer minUnits;

    @NotNull(message = "Max units can't be null")
    private Double price;

    @NotBlank(message = "This space can't be empty")
    private String providerName;
}
