package com.iviconsulting.linkgenerator.InvoiceControllerTest;

import com.iviconsulting.linkgenerator.controller.InvoiceController;
import com.iviconsulting.linkgenerator.dto.InvoiceDTO;
import com.iviconsulting.linkgenerator.model.Invoice;
import com.iviconsulting.linkgenerator.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InvoiceControllerTest {

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    @Test
    public void testGetAllInvoices() {
        // Arrange
        Invoice invoice1 = new Invoice();
        invoice1.setId(1L);
        invoice1.setAmount(new BigDecimal("100.00"));

        Invoice invoice2 = new Invoice();
        invoice2.setId(2L);
        invoice2.setAmount(new BigDecimal("200.00"));

        List<Invoice> invoices = Arrays.asList(invoice1, invoice2);
        when(invoiceService.getAllInvoices()).thenReturn(invoices);

        // Act
        List<Invoice> result = invoiceController.getAllInvoices();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(new BigDecimal("100.00"), result.get(0).getAmount());
        assertEquals(2L, result.get(1).getId());
        assertEquals(new BigDecimal("200.00"), result.get(1).getAmount());
    }
}
