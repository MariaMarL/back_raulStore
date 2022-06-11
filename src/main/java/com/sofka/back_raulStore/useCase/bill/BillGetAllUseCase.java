package com.sofka.back_raulStore.useCase.bill;

import com.sofka.back_raulStore.dto.BillDto;
import com.sofka.back_raulStore.mapper.BillMapper;
import com.sofka.back_raulStore.mapper.ProductMapper;
import com.sofka.back_raulStore.repository.BillRepository;
import com.sofka.back_raulStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class BillGetAllUseCase {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public Flux<BillDto> getBills(){
        return billRepository.findAll().map(billMapper::toBillDto);
    }
}
