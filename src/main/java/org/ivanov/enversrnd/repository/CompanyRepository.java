package org.ivanov.enversrnd.repository;

import org.ivanov.enversrnd.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
