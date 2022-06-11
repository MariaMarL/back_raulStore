package com.sofka.back_raulStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "bill" )
public class Bill {

    @Id
    private String id;
    private LocalDate date;
    private String ClientName;
    private String SellerName;
    private List<String> productId;
    private Double total;
}
