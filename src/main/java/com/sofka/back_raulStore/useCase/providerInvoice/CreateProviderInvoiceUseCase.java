package com.sofka.back_raulStore.useCase.providerInvoice;

import com.sofka.back_raulStore.collections.ProviderInvoice;
import com.sofka.back_raulStore.dto.ProviderInvoiceDto;
import com.sofka.back_raulStore.mapper.ProviderInvoiceMapper;
import com.sofka.back_raulStore.repository.ProviderInvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
@AllArgsConstructor
@Validated
public class CreateProviderInvoiceUseCase {

    private final ProviderInvoiceRepository repository;
    private final ProviderInvoiceMapper mapper;

    public Mono<ProviderInvoiceDto> createProviderInvoice(@Valid ProviderInvoiceDto providerInvoiceDto){
            providerInvoiceDto.setDate(LocalDate.now());
            return repository.save(mapper.toProviderInvoice(providerInvoiceDto))
                    .map(mapper::toProviderInvoiceDto);

    }
}
