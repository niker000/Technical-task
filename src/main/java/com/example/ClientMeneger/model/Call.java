package com.example.ClientMeneger.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @OneToOne
    @NotNull
    @JsonBackReference
    private Client client;

    @OneToOne
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "phoneNumber")
    private PhoneNumber callersPhoneNumber;

    @OneToOne
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "phoneNumber")
    private PhoneNumber recipientsPhoneNumber;

    @NotNull
    private LocalDateTime date;
    @NotNull
    private Duration duration;
    private String city;

    public Call() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public PhoneNumber getCallersPhoneNumber() {
        return callersPhoneNumber;
    }

    public void setCallersPhoneNumber(PhoneNumber callersPhoneNumber) {
        this.callersPhoneNumber = callersPhoneNumber;
    }

    public PhoneNumber getRecipientsPhoneNumber() {
        return recipientsPhoneNumber;
    }

    public void setRecipientsPhoneNumber(PhoneNumber recipientsPhoneNumber) {
        this.recipientsPhoneNumber = recipientsPhoneNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
