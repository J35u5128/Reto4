package org.example.reto4.Repositories;

import org.example.reto4.Entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de Spring Data para la entidad {@link Hotel}.
 * Proporciona métodos CRUD (Crear, Leer, Actualizar, Borrar) para los hoteles
 * interactuando con la base de datos MongoDB.
 */
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
