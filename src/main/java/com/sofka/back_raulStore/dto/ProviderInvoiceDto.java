package com.sofka.back_raulStore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ProviderInvoiceDto {

    private String id;
    @NotBlank(message = "Choose a product")
    private String productId;
    @NotNull(message = "Enter amount")
    private Integer amount;
    private String date;
    @NotBlank(message = "Choose a provider")
    private String providerId;
}
