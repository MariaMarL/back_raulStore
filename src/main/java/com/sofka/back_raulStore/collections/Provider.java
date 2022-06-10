package com.sofka.back_raulStore.collections;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "provider")
public class Provider {

    @Id
    private String id;
    private String name;
    private String dni;
    private String phone;

}
