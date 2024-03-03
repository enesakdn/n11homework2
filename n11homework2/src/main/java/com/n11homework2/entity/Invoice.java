package com.n11homework2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private LocalDate invoiceDate;
    private Double amount;
    private Order order;


    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceDateTime=" + invoiceDate +
                ", amount=" + amount +
                ", order=" + order +
                '}';
    }
}