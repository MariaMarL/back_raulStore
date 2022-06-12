package com.sofka.back_raulStore.useCase.bill;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.mapper.BillMapper;
import com.sofka.back_raulStore.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
@AllArgsConstructor
@Validated
public class BillCreateUseCase {

    private final BillRepository repository;
    private final BillMapper mapper;

    public Mono<BillDto> createBill (@Valid BillDto billDto){
        billDto.setDate(LocalDate.now().toString());
        return repository.save(mapper.toBillEntity(billDto))
                .map(mapper::toBillDto);
    }
}
