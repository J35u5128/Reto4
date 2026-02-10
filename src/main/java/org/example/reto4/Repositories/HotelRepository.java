package org.example.reto4.Repositories;

import org.example.reto4.Entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}

