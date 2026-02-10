package org.example.reto4.Repositories;

import org.example.reto4.Entities.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
}
