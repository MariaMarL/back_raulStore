package com.sofka.back_raulStore.provider.repository;

import com.sofka.back_raulStore.provider.collections.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider, String> {
    //String = type of the id.
}
