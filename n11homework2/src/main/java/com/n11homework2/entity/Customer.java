package com.n11homework2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String industry;
    private LocalDate registrationDate;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}