package com.example.ClientMeneger.repositoryes;

import com.example.ClientMeneger.model.Call;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallRepo extends CrudRepository<Call, BigInteger> {
    interface CallStatisticsByCity {
        String getCity();
        BigInteger getCount();
    }
    @Query(value = "SELECT call.city, COUNT(call) FROM call " +
            "GROUP BY call.city", nativeQuery = true)
    List<CallStatisticsByCity> countCallByCity();

    Call findFirstByClient_IdAndDateBetweenOrderByDurationDesc(BigInteger clientId, LocalDateTime start, LocalDateTime end);
}

