package org.ivanov.enversrnd;

import org.ivanov.enversrnd.repository.CompanyRepository;
import org.ivanov.enversrnd.repository.CustomerRepository;
import org.ivanov.enversrnd.util.SqlFileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class EnversRndApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    private final TransactionTemplate transactionTemplate;

    public EnversRndApplication(CustomerRepository customerRepository,
                                CompanyRepository companyRepository,
                                TransactionTemplate transactionTemplate) {
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
        this.transactionTemplate = transactionTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {
        SpringApplication.run(EnversRndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        transactionTemplate.execute(status -> {
            entityManager.createNativeQuery(SqlFileReader.readQuery("companies.sql")).executeUpdate();
            entityManager.createNativeQuery(SqlFileReader.readQuery("customers.sql")).executeUpdate();
            return null;
        });
    }
}
