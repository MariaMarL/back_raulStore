package com.sofka.back_raulStore.useCase.provider;


import com.sofka.back_raulStore.dto.ProviderDto;
import com.sofka.back_raulStore.mapper.ProviderMapper;
import com.sofka.back_raulStore.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
public class ProviderCreateUseCase {


    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Mono<ProviderDto> create(@Valid ProviderDto providerDto){
        return providerRepository.save(providerMapper.toProviderEntity(providerDto))
                .map(providerMapper::toProviderDto);
    }
}
