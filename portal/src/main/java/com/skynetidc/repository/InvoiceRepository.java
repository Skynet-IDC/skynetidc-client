package com.skynetidc.repository;

import com.skynetidc.model.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long> {

}
