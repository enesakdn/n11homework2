package com.n11homework2.service.impl;

import com.n11homework2.entity.Customer;
import com.n11homework2.entity.Invoice;
import com.n11homework2.service.InvoiceService;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {
    List<Invoice> invoices;

    public InvoiceServiceImpl(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    @Override
    public List<Invoice> getAll() {
        return invoices;
    }

    @Override
    public void add(Invoice customer) {
        invoices.add(customer);
    }

    @Override
    public List<Invoice> getInvoicesWithTotalAmountGreaterThan(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getAmount() > amount)
                .toList();
    }

    @Override
    public double calculateAverageAmountOfInvoicesAbove(double thresholdAmount) {
        return invoices.stream()
                .filter(invoice -> invoice.getAmount() > thresholdAmount)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    @Override
    public List<String> getCustomersWithInvoicesBelow(double thresholdAmount) {
        return invoices.stream()
                .filter(invoice -> invoice.getAmount() < thresholdAmount)
                .map(invoice -> invoice.getOrder().getCustomer().getName())
                .toList();
    }

    @Override
    public List<String> listIndustriesWithInvoiceAverageBelowInMonth(int month, double thresholdAmount) {
        return invoices.stream()
                .filter(invoice -> invoice.getOrder().getCustomer() instanceof Customer)
                .filter(invoice -> invoice.getInvoiceDate().getMonthValue() == month)
                .filter(invoice -> invoice.getAmount() < thresholdAmount)
                .map(invoice -> (invoice.getOrder().getCustomer()).getIndustry())
                .toList();
    }

    @Override
    public double getTotalAmountOfInvoicesForCustomersRegistrationInMonth(int month) {
        return invoices.stream()
                .filter(invoice -> invoice.getOrder().getCustomer().getRegistrationDate().getMonthValue() == month)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }
}