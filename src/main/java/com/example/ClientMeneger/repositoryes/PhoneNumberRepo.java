package com.example.ClientMeneger.repositoryes;

import com.example.ClientMeneger.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepo extends CrudRepository<PhoneNumber, String> {
}
