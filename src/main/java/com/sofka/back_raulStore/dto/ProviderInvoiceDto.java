package com.sofka.back_raulStore.dto;

import com.sofka.back_raulStore.collections.Product;
import com.sofka.back_raulStore.collections.Provider;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProviderInvoiceDto {

    private String id;
    @NotBlank(message = "Product can't be empty")
    private Product product;
    @NotBlank(message = "Date can't be empty")
    private LocalDate date;
    private Provider provider;
}
