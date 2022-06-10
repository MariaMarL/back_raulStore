package com.sofka.back_raulStore.product.repository;

import com.sofka.back_raulStore.product.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
