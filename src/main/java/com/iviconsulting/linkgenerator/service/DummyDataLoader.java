package com.iviconsulting.linkgenerator.service;

import com.iviconsulting.linkgenerator.model.Invoice;
import com.iviconsulting.linkgenerator.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class DummyDataLoader implements CommandLineRunner {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create and save dummy invoices
        Invoice invoice1 = new Invoice();
        invoice1.setInvoiceNumber("INV-001");
        invoice1.setInvoiceDate(new Date());
        invoice1.setAmount(new BigDecimal("100.00"));
        invoiceRepository.save(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceNumber("INV-002");
        invoice2.setInvoiceDate(new Date());
        invoice2.setAmount(new BigDecimal("200.00"));
        invoiceRepository.save(invoice2);

        // Add more invoices as needed
    }
}
