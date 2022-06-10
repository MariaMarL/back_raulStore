package com.sofka.back_raulStore.provider.useCase;

import com.sofka.back_raulStore.provider.dto.ProviderDto;
import com.sofka.back_raulStore.provider.mapper.ProviderMapper;
import com.sofka.back_raulStore.provider.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ProvidersGetAllUseCase {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Flux<ProviderDto> getProviders(){
        return providerRepository.findAll().map(providerMapper::toProviderDto);
        //return providerRepository.findAll().map(provider -> providerMapper.toProviderDto(provider));
    }
}
