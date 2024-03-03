package com.n11homework2.service;

import com.n11homework2.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    List<Customer> getCustomersWithLetter(String letter);
}