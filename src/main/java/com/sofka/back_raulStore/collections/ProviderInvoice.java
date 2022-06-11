package com.sofka.back_raulStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Document(collection = "providerInvoice")
public class ProviderInvoice {

    @Id
    private String id;
    @NotBlank
    private Product product;
    @NotBlank
    private LocalDateTime date;
    @NotBlank
    private Provider provider;
}
