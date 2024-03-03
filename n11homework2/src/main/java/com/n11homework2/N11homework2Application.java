package com.n11homework2;

import com.n11homework2.entity.Customer;
import com.n11homework2.entity.Invoice;
import com.n11homework2.entity.Order;
import com.n11homework2.service.impl.CustomerServiceImpl;
import com.n11homework2.service.impl.InvoiceServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class N11homework2Application {

	public static void main(String[] args) {
		// Sample data initialization
		List<Customer> customers = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		List<Invoice> invoices = new ArrayList<>();

		Customer customer1 = new Customer("ABC Company", "Technology", LocalDate.of(2022, 6, 15));
		Customer customer2 = new Customer("XYZ Ltd.", "Finance", LocalDate.of(2022, 6, 20));
		Customer customer3 = new Customer("Sample Corp", "Healthcare", LocalDate.of(2022, 5, 10));

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);

		Order order1 = new Order(customer1);
		Order order2 = new Order(customer2);

		orders.add(order1);
		orders.add(order2);

		Invoice invoice1 = new Invoice(LocalDate.of(2022, 6, 25), 1200.0, order1);
		Invoice invoice2 = new Invoice(LocalDate.of(2022, 6, 30), 1800.0, order2);
		Invoice invoice3 = new Invoice(LocalDate.of(2022, 5, 20), 500.0, order1);

		invoices.add(invoice1);
		invoices.add(invoice2);
		invoices.add(invoice3);

		// Service implementations
		CustomerServiceImpl customerService = new CustomerServiceImpl(customers);
		InvoiceServiceImpl invoiceService = new InvoiceServiceImpl(invoices);

		// Functionality implementation
		System.out.println("Tüm müşteriler:");
		customerService.getAllCustomers().forEach(System.out::println);

		System.out.println("\nYeni müşteri oluştur:");
		Customer newCustomer = new Customer("New Corp", "Retail", LocalDate.now());
		customerService.addCustomer(newCustomer);
		customerService.getAllCustomers().forEach(System.out::println);

		System.out.println("\n'C' harfi içeren müşteriler:");
		customerService.getCustomersWithLetter("C").forEach(System.out::println);

		System.out.println("\nHaziran ayında kayıt olan müşterilerin fatura toplam tutarı:");
		double totalInvoicesInJune = invoiceService.getTotalAmountOfInvoicesForCustomersRegistrationInMonth(6);
		System.out.println("Toplam tutar: " + totalInvoicesInJune);

		System.out.println("\nSistemdeki tüm faturalar:");
		invoiceService.getAll().forEach(System.out::println);

		System.out.println("\nSistemdeki 1500TL üstündeki faturalar:");
		invoiceService.getInvoicesWithTotalAmountGreaterThan(1500.0).forEach(System.out::println);

		System.out.println("\nSistemdeki 1500TL üstündeki faturaların ortalaması:");
		double averageAmount = invoiceService.calculateAverageAmountOfInvoicesAbove(1500.0);
		System.out.println("Ortalama tutar: " + averageAmount);

		System.out.println("\nSistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri:");
		invoiceService.getCustomersWithInvoicesBelow(500.0).forEach(System.out::println);

		System.out.println("\nHaziran ayındaki faturaların ortalaması 750 altı olan firmaların sektörleri:");
		List<String> industries = invoiceService.listIndustriesWithInvoiceAverageBelowInMonth(6, 750.0);
		industries.forEach(System.out::println);
	}

}
