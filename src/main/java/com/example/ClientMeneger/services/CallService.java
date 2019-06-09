package com.example.ClientMeneger.services;

import com.example.ClientMeneger.model.Call;
import com.example.ClientMeneger.model.CallDTO;


import com.example.ClientMeneger.model.Client;
import com.example.ClientMeneger.repositoryes.CallRepo;
import com.example.ClientMeneger.repositoryes.ClientRepo;
import com.example.ClientMeneger.repositoryes.PhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CallService {
    private CallRepo callRepo;
    private PhoneNumberRepo phoneNumberRepo;
    private ClientRepo clientRepo;

    public CallService(CallRepo callRepo, PhoneNumberRepo phoneNumberRepo, ClientRepo clientRepo) {
        this.callRepo = callRepo;
        this.phoneNumberRepo = phoneNumberRepo;
        this.clientRepo = clientRepo;
    }

    public Call createCall(CallDTO callDTO) {
        if(!phoneNumberRepo.existsById(callDTO.getRecipientsPhoneNumber().getPhoneNumber())){
            phoneNumberRepo.save(callDTO.getRecipientsPhoneNumber());
        }

        Call call = new Call();
        Client client = clientRepo.findByPhoneNumbers(callDTO.getCallersPhoneNumber());
        if(client==null) {
            client = clientRepo.findByPhoneNumbers(callDTO.getRecipientsPhoneNumber());
        }

        call.setClient(client);
        call.setCallersPhoneNumber(callDTO.getCallersPhoneNumber());
        call.setRecipientsPhoneNumber(callDTO.getRecipientsPhoneNumber());
        call.setDate(callDTO.getDate());
        call.setDuration(callDTO.getDuration());
        call.setCity(callDTO.getCity());

        return callRepo.save(call);
    }

    public Call getLongestCall(BigInteger clientId, LocalDate start, LocalDate end) {
        return callRepo.findFirstByClient_IdAndDateBetweenOrderByDurationDesc(clientId,
                LocalDateTime.of(start, LocalTime.MIN),
                LocalDateTime.of(end,LocalTime.MIN));
    }

    public List<CallRepo.CallStatisticsByCity> getCallStatisticByCity() {
       return callRepo.countCallByCity();
    }
}
