package com.sofka.back_raulStore.useCase.provider;

import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.mapper.ProviderMapper;
import com.sofka.back_raulStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProviderFindByIdUseCase {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Mono<ProviderDto> getProviderById(String id){

        return providerRepository.findById(id)
                .switchIfEmpty(Mono.error(()-> new IllegalStateException("Provider not found. ID: "+id)))
                .map(providerMapper::toProviderDto);

    }
}
