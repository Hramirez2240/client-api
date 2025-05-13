package com.oriontek.clientapi.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "clients")
public class Client extends BaseEntity {

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
