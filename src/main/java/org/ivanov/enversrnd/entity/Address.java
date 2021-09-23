package org.ivanov.enversrnd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "HOME_NUMBER", nullable = false)
    private Integer homeNumber;

}
