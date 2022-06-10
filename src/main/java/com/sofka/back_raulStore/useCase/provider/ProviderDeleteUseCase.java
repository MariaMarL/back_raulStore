package com.sofka.back_raulStore.useCase.provider;

import com.sofka.back_raulStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProviderDeleteUseCase {

    private final ProviderRepository providerRepository;

    public Mono<Void> delete(String id){
        return providerRepository.findById(id)
                .switchIfEmpty(Mono.error(()-> new IllegalStateException("Provider not found. ID: " + id)))
                .flatMap(provider -> providerRepository.deleteById(provider.getId()));
    }
}
