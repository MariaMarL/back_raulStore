package com.sofka.back_raulStore.repository;

import com.sofka.back_raulStore.collections.Provider;
import com.sofka.back_raulStore.dto.ProviderDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider, String> {
    //String = type of the id.
}
