package com.sofka.back_raulStore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
public class BillDto {

    private String id;
    private LocalDate date;
    @NotBlank(message = "Please enter the client Name")
    private String clientName;
    @NotBlank(message = "Please enter the Seller Name")
    private String sellerName;
    private List<String> productId;
    private Double total;
}
