package org.example.reto4.Repositories;

import org.example.reto4.Entities.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de Spring Data para la entidad {@link Reserva}.
 * Proporciona métodos CRUD (Crear, Leer, Actualizar, Borrar) para las reservas
 * interactuando con la base de datos MongoDB.
 */
public interface ReservaRepository extends MongoRepository<Reserva, String> {
}
