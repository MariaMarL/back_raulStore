package com.sofka.back_raulStore.useCase;

import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.mapper.ProviderMapper;
import com.sofka.back_raulStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProviderGetProviderName {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Mono<ProviderDto> getProviderByProviderName(String name){

        return providerRepository.findByname(name)
                .switchIfEmpty(Mono.error(()-> new IllegalStateException("Provider " + name+ " not found")))
                .map(providerMapper::toProviderDto);

    }
}
