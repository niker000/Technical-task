package com.example.ClientMeneger.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {
    @Id
    private String phoneNumber;

    @ManyToOne
    @JsonBackReference
    private Client client;

    public PhoneNumber() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {

        this.client = client;
    }
}
