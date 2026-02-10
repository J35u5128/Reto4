package org.example.reto4.Controller;

import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import org.example.reto4.Repositories.HotelRepository;
import org.example.reto4.Repositories.ReservaRepository;
import org.example.reto4.Entities.Reserva;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository reservaRepo;
    private final HotelRepository hotelRepo;

    public ReservaController(ReservaRepository reservaRepo, HotelRepository hotelRepo) {
        this.reservaRepo = reservaRepo;
        this.hotelRepo = hotelRepo;
    }

    @PostMapping
    public Reserva crear(@RequestParam String hotelId,
                         @RequestBody @Valid Reserva reserva) {

        hotelRepo.findById(hotelId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Hotel " + hotelId + " no encontrado"));

        reserva.setHotelId(hotelId);
        return reservaRepo.save(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }
}
