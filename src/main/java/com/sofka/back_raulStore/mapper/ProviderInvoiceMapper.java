package com.sofka.back_raulStore.mapper;

import com.sofka.back_raulStore.collections.ProviderInvoice;
import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProviderInvoiceMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ProviderInvoiceDto toProviderInvoiceDto(ProviderInvoice providerInvoice){
        return modelMapper.map(providerInvoice, ProviderInvoiceDto.class);
    }

    public ProviderInvoice toProviderInvoice(ProviderInvoiceDto providerInvoiceDto){
        return modelMapper.map(providerInvoiceDto, ProviderInvoice.class);
    }
}
