package org.ivanov.enversrnd;

import lombok.RequiredArgsConstructor;
import org.ivanov.enversrnd.entity.Address;
import org.ivanov.enversrnd.entity.Company;
import org.ivanov.enversrnd.entity.Customer;
import org.ivanov.enversrnd.repository.CompanyRepository;
import org.ivanov.enversrnd.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.file.Files;
import java.util.Collections;

@RequiredArgsConstructor
@SpringBootApplication
public class EnversRndApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(EnversRndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        if (companyRepository.count() == 0) {
//            entityManager.createNativeQuery()
//        }
//        if (customerRepository.count() == 0) {
//
//        }
        Company company = new Company();
        Customer customer = new Customer();
        customer.setName("Rich");
        customer.setAddress(new Address("Backer", 128));
        customer.setCompany(company);
        company.setCustomers(Collections.singletonList(customer));
        companyRepository.save(company);
    }
}
