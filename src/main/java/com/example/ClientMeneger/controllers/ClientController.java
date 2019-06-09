package com.example.ClientMeneger.controllers;

import com.example.ClientMeneger.model.Client;
import com.example.ClientMeneger.repositoryes.ClientRepo;
import com.example.ClientMeneger.services.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clients")
public class ClientController {
    private ClientService clientService;
    private ClientRepo clientRepo;

    public ClientController(ClientService clientService, ClientRepo clientRepo) {
        this.clientService = clientService;
        this.clientRepo = clientRepo;
    }

    @GetMapping
    public Iterable<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @PostMapping
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }
}
