package com.example.ClientMeneger.services;

import com.example.ClientMeneger.model.Client;
import com.example.ClientMeneger.repositoryes.ClientRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    private ClientRepo clientRepository;

    @InjectMocks
    ClientService clientService;

    @Test
    public void createClient() {
        Client expectedClient = new Client();
        when(clientRepository.save(any())).thenReturn(expectedClient);

        Client client = clientService.createClient(expectedClient);

        assertEquals(expectedClient.getId(),client.getId());
    }
}