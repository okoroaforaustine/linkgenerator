package com.iviconsulting.linkgenerator.service;

import com.iviconsulting.linkgenerator.dto.InvoiceDTO;
import com.iviconsulting.linkgenerator.model.Invoice;
import com.iviconsulting.linkgenerator.repository.InvoiceRepository;
import com.iviconsulting.linkgenerator.utils.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDTO getInvoiceDetails(Long invoiceId) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();
            // Convert entity to DTO
            return convertToDTO(invoice);
        } else {
            throw new NotFoundExceptions();
        }
    }

    public String generatePaymentLink(Long invoiceId) {
        String paymentLink = "https://iviconsulting/payments/" + invoiceId;
        return paymentLink;
    }

    private InvoiceDTO convertToDTO(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setAmount(invoice.getAmount());
        invoiceDTO.setDueDate(invoice.getDueDate());
        // Map other attributes as needed
        return invoiceDTO;
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }
}
