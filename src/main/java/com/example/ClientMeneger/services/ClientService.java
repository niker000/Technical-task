package com.example.ClientMeneger.services;

import com.example.ClientMeneger.model.Client;
import com.example.ClientMeneger.repositoryes.ClientRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client createClient(Client client) {
        clientRepo.save(client);
        return client;
    }
}
