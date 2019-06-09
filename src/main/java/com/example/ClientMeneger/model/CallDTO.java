package com.example.ClientMeneger.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Duration;
import java.time.LocalDateTime;

public class CallDTO {
    private PhoneNumber callersPhoneNumber;

    private PhoneNumber recipientsPhoneNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private Duration duration;

    private String city;

    public CallDTO() {
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

}
