package com.sofka.back_raulStore.provider.mapper;

import com.sofka.back_raulStore.provider.collections.Provider;
import com.sofka.back_raulStore.provider.dto.ProviderDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProviderMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ProviderDto toProviderDto(Provider provider){
        return modelMapper.map(provider, ProviderDto.class);
    }

    public Provider toProviderEntity (ProviderDto providerDto){
        return modelMapper.map(providerDto, Provider.class);
    }
}
