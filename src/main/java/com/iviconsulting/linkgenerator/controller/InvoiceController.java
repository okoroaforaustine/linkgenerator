package com.iviconsulting.linkgenerator.controller;

import com.iviconsulting.linkgenerator.dto.InvoiceDTO;
import com.iviconsulting.linkgenerator.model.Invoice;
import com.iviconsulting.linkgenerator.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getInvoiceDetails(@PathVariable Long invoiceId) {
        // Call service layer to get invoice details
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDetails(invoiceId);
        return ResponseEntity.ok(invoiceDTO);
    }

    @PostMapping("/{invoiceId}/payment-links")
    public ResponseEntity<String> generatePaymentLink(@PathVariable Long invoiceId) {
        // Call service layer to generate payment link
        String paymentLink = invoiceService.generatePaymentLink(invoiceId);
        return ResponseEntity.ok(paymentLink);
    }
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
}
