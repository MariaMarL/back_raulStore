package com.sofka.back_raulStore.collections;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "provider")
public class Provider {

    @MongoId
    private String id;
    @NotBlank(message = "Please type your name")
    private String name;
    @NotBlank (message = "Please type you dni number")
    private String dni;
    @NotBlank (message = "Please type you phone number")
    private String phone;

}
