package com.example.ClientMeneger.repositoryes;

import com.example.ClientMeneger.model.Client;
import com.example.ClientMeneger.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface ClientRepo extends CrudRepository<Client, BigInteger> {
    Client findByPhoneNumbers(PhoneNumber phoneNumber);
}
