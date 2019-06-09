package com.example.ClientMeneger.services;

import com.example.ClientMeneger.model.Call;
import com.example.ClientMeneger.model.CallDTO;
import com.example.ClientMeneger.model.PhoneNumber;
import com.example.ClientMeneger.repositoryes.CallRepo;
import com.example.ClientMeneger.repositoryes.ClientRepo;
import com.example.ClientMeneger.repositoryes.PhoneNumberRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CallServiceTest {
    @Mock
    CallRepo callRepository;
    @Mock
    private PhoneNumberRepo phoneNumberRepo;
    @Mock
    private ClientRepo clientRepo;
    @Mock
    CallDTO callDTO;

    @InjectMocks
    private CallService callService;

    Call expectedCall;

    @Before
    public void setUp() {
        expectedCall = new Call();
    }
    @Test
    public void createCallIfNumberExist() {

        PhoneNumber recipientPhone = new PhoneNumber();
        recipientPhone.setPhoneNumber("123");
        when(phoneNumberRepo.existsById(recipientPhone.getPhoneNumber())).thenReturn(true);
        when(callRepository.save(any())).thenReturn(expectedCall);
        when(callDTO.getRecipientsPhoneNumber()).thenReturn(recipientPhone);

        Call call = callService.createCall(callDTO);

        assertEquals(expectedCall.getId(), call.getId());
    }

    @Test
    public void createCallIfNumberNotExists() {

        PhoneNumber recipientPhone = new PhoneNumber();
        recipientPhone.setPhoneNumber("123");
        when(phoneNumberRepo.existsById(recipientPhone.getPhoneNumber())).thenReturn(false);
        when(callRepository.save(any())).thenReturn(expectedCall);
        when(callDTO.getRecipientsPhoneNumber()).thenReturn(recipientPhone);

        Call call = callService.createCall(callDTO);

        verify(phoneNumberRepo).save(callDTO.getRecipientsPhoneNumber());
        assertEquals(expectedCall.getId(), call.getId());
    }

    @Test
    public void getLongestCall() {

        when(callRepository.findFirstByClient_IdAndDateBetweenOrderByDurationDesc(any(), any(), any())).thenReturn(expectedCall);

        Call call = callRepository.findFirstByClient_IdAndDateBetweenOrderByDurationDesc(any(), any(), any());

        assertEquals(expectedCall.getId(), call.getId());
    }

    @Test
    public void getCallStatisticByCity() {
        callService.getCallStatisticByCity();

        verify(callRepository).countCallByCity();
    }
}