package org.example.reto4.Controller;

import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import org.example.reto4.Repositories.HotelRepository;
import org.example.reto4.Repositories.ReservaRepository;
import org.example.reto4.Entities.Reserva;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de reservas.
 * Expone endpoints para crear y listar reservas.
 */
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository reservaRepo;
    private final HotelRepository hotelRepo;

    /**
     * Constructor para la inyección de dependencias de los repositorios de reservas y hoteles.
     * @param reservaRepo El repositorio para las operaciones de base de datos de reservas.
     * @param hotelRepo El repositorio para las operaciones de base de datos de hoteles.
     */
    public ReservaController(ReservaRepository reservaRepo, HotelRepository hotelRepo) {
        this.reservaRepo = reservaRepo;
        this.hotelRepo = hotelRepo;
    }

    /**
     * Endpoint para crear una nueva reserva.
     * Antes de crear la reserva, verifica que el hotel asociado exista.
     * @param hotelId El ID del hotel al que se asociará la reserva.
     * @param reserva El objeto {@link Reserva} a crear, validado.
     * @return La reserva guardada con su ID asignado.
     * @throws RecursoNoEncontradoException si el hotel con el `hotelId` proporcionado no existe.
     */
    @PostMapping
    public Reserva crear(@RequestParam String hotelId,
                         @RequestBody @Valid Reserva reserva) {

        // Verifica que el hotel exista antes de crear la reserva.
        hotelRepo.findById(hotelId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Hotel " + hotelId + " no encontrado"));

        // Asigna el ID del hotel a la reserva y la guarda.
        reserva.setHotelId(hotelId);
        return reservaRepo.save(reserva);
    }

    /**
     * Endpoint para obtener una lista de todas las reservas.
     * @return Una lista de objetos {@link Reserva}.
     */
    @GetMapping
    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }
}
