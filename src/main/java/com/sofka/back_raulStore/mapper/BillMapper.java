package com.sofka.back_raulStore.mapper;

import com.sofka.back_raulStore.collections.Bill;
import com.sofka.back_raulStore.dto.BillDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class BillMapper {

    private final ModelMapper modelMapper =new ModelMapper();

    public BillDto toBillDto (Bill bill){
        return modelMapper.map(bill,BillDto.class);
    }

    public Bill toBillEntity (BillDto billDto){
        return modelMapper.map(billDto, Bill.class);
    }
}
