package org.example.reto4.Controller;

import org.example.reto4.Entities.Hotel;
import org.example.reto4.Repositories.HotelRepository;
import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones CRUD de los hoteles.
 * Expone endpoints para listar, ver, crear y actualizar hoteles.
 */
@RestController
@RequestMapping("/hoteles")
public class HotelController {

    private final HotelRepository repo;

    /**
     * Constructor para la inyección de dependencias del repositorio de hoteles.
     * @param repo El repositorio para las operaciones de base de datos de hoteles.
     */
    public HotelController(HotelRepository repo) {
        this.repo = repo;
    }

    /**
     * Endpoint para obtener una lista de todos los hoteles.
     * @return Una lista de objetos {@link Hotel}.
     */
    @GetMapping
    public List<Hotel> listar() {
        return repo.findAll();
    }

    /**
     * Endpoint para obtener los detalles de un hotel específico por su ID.
     * @param id El ID del hotel a buscar.
     * @return El objeto {@link Hotel} correspondiente al ID.
     * @throws RecursoNoEncontradoException si no se encuentra ningún hotel con el ID proporcionado.
     */
    @GetMapping("/{id}")
    public Hotel detalle(@PathVariable String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Hotel " + id + " no encontrado"));
    }

    /**
     * Endpoint para crear un nuevo hotel.
     * Este endpoint está protegido y solo es accesible para usuarios con el rol 'ADMIN'.
     * @param hotel El objeto {@link Hotel} a crear, validado.
     * @return El hotel guardado con su ID asignado.
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel crear(@RequestBody @Valid Hotel hotel) {
        return repo.save(hotel);
    }

    /**
     * Endpoint para actualizar un hotel existente.
     * Este endpoint está protegido y solo es accesible para usuarios con el rol 'ADMIN'.
     * @param id El ID del hotel a actualizar.
     * @param hotel El objeto {@link Hotel} con los nuevos datos.
     * @return El hotel actualizado.
     * @throws RecursoNoEncontradoException si el hotel a actualizar no se encuentra.
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel actualizar(@PathVariable String id, @RequestBody @Valid Hotel hotel) {
        // Primero, se busca el hotel existente para asegurarse de que existe.
        Hotel existente = detalle(id);
        // Se actualizan los campos del hotel existente con los nuevos valores.
        existente.setNombre(hotel.getNombre());
        existente.setCiudad(hotel.getCiudad());
        existente.setEstrellas(hotel.getEstrellas());
        existente.setPrecioNoche(hotel.getPrecioNoche());
        // Se guarda el hotel actualizado en la base de datos.
        return repo.save(existente);
    }
}
