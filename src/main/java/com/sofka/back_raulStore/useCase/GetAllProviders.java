package com.sofka.back_raulStore.useCase;

import com.sofka.back_raulStore.collections.Provider;
import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.mapper.ProviderMapper;
import com.sofka.back_raulStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProviders {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Flux<ProviderDto> getProviders(){
        return providerRepository.findAll().map(providerMapper::toProviderDto);
        //return providerRepository.findAll().map(provider -> providerMapper.toProviderDto(provider));
    }
}
