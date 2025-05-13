package com.oriontek.clientapi.model.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "addresses")
public class Address extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
