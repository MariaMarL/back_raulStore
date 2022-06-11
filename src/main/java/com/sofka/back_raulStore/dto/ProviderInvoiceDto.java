package com.sofka.back_raulStore.dto;

import com.sofka.back_raulStore.collections.Product;
import com.sofka.back_raulStore.collections.Provider;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProviderInvoiceDto {

    private String id;
    @NotNull
    private Product product;
    private LocalDate date;
    @NotNull
    private Provider provider;
}
