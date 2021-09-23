package org.ivanov.enversrnd;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.ivanov.enversrnd.entity.Company;
import org.ivanov.enversrnd.entity.Customer;
import org.ivanov.enversrnd.repository.CompanyRepository;
import org.ivanov.enversrnd.repository.CustomerRepository;
import org.ivanov.enversrnd.util.SqlFileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RequiredArgsConstructor
@SpringBootApplication
public class EnversRndApplication {

    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(EnversRndApplication.class, args);
    }

    @SneakyThrows
    @EventListener(ContextRefreshedEvent.class)
    public void initEntities() {
        transactionTemplate.execute(status -> {
            entityManager.createNativeQuery(SqlFileReader.readQuery("companies.sql")).executeUpdate();
            entityManager.createNativeQuery(SqlFileReader.readQuery("customers.sql")).executeUpdate();
            return null;
        });

        transactionTemplate.execute(status -> {
            Company anotherCompany = companyRepository.findById(2L).orElseThrow();
            Customer firstCustomer = customerRepository.findById(1L).orElseThrow();
            firstCustomer.setCompany(anotherCompany);
            return customerRepository.save(firstCustomer);
        });
    }
}
