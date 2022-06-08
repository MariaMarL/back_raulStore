package com.sofka.back_raulStore.repository;

import com.sofka.back_raulStore.collections.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider, String> {

    //String = type of the id.
}
