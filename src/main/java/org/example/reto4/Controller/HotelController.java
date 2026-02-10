package org.example.reto4.Controller;

import org.example.reto4.Entities.Hotel;
import org.example.reto4.Repositories.HotelRepository;
import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    private final HotelRepository repo;

    public HotelController(HotelRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Hotel> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Hotel detalle(@PathVariable String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Hotel " + id + " no encontrado"));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel crear(@RequestBody @Valid Hotel hotel) {
        return repo.save(hotel);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel actualizar(@PathVariable String id, @RequestBody @Valid Hotel hotel) {
        Hotel existente = detalle(id);
        existente.setNombre(hotel.getNombre());
        existente.setCiudad(hotel.getCiudad());
        existente.setEstrellas(hotel.getEstrellas());
        existente.setPrecioNoche(hotel.getPrecioNoche());
        return repo.save(existente);
    }
}
