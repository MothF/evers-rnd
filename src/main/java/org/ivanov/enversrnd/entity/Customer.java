package org.ivanov.enversrnd.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;


@Getter
@Setter
//@Audited
@Table(name = "CUSTOMERS")
@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "customerSeqGen", sequenceName = "CUSTOMER_ID_SEQUENCE", allocationSize = 10)
    @GeneratedValue(generator = "customerSeqGen")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "ADDRESS_STREET")),
            @AttributeOverride(name = "homeNumber", column = @Column(name = "ADDRESS_HOME_NUMBER"))
    })
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;

}
