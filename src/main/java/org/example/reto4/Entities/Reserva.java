package org.example.reto4.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Representa la entidad de una Reserva en la base de datos MongoDB.
 * Esta clase se mapea a la colección "reservas".
 */
@Document(collection = "reservas")
public class Reserva {

    /**
     * El identificador único de la reserva, generado por MongoDB.
     */
    @Id
    private String id;

    /**
     * El nombre del cliente que realiza la reserva.
     */
    private String cliente;

    /**
     * La fecha de inicio de la reserva.
     */
    private LocalDate fechaEntrada;

    /**
     * La fecha de fin de la reserva.
     */
    private LocalDate fechaSalida;

    /**
     * El ID del hotel al que está asociada esta reserva.
     * Se almacena como una referencia simple para mantener el modelo desacoplado.
     */
    private String hotelId;

    /**
     * Constructor por defecto.
     */
    public Reserva() {
    }

    // Getters y Setters con Javadoc

    /**
     * @return El ID de la reserva.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id El nuevo ID de la reserva.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return El nombre del cliente.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente El nuevo nombre del cliente.
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return La fecha de entrada de la reserva.
     */
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * @param fechaEntrada La nueva fecha de entrada.
     */
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * @return La fecha de salida de la reserva.
     */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida La nueva fecha de salida.
     */
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return El ID del hotel asociado a la reserva.
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * @param hotelId El nuevo ID del hotel a asociar.
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
