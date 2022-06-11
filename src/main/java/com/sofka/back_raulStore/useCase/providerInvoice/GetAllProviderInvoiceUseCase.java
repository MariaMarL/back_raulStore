package com.sofka.back_raulStore.useCase.providerInvoice;

import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.mapper.ProviderInvoiceMapper;
import com.sofka.back_raulStore.repository.ProviderInvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProviderInvoiceUseCase {

    private final ProviderInvoiceRepository repository;
    private final ProviderInvoiceMapper mapper;

    public Flux<ProviderInvoiceDto> getAllProviderInvoice(){
        return repository.findAll().map(mapper::toProviderInvoiceDto);
    }
}
