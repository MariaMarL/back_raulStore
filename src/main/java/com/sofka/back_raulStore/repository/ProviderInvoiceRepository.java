package com.sofka.back_raulStore.repository;

import com.sofka.back_raulStore.collections.ProviderInvoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProviderInvoiceRepository extends ReactiveMongoRepository<ProviderInvoice, String> {
}
