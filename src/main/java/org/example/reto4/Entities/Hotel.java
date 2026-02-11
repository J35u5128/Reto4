package org.example.reto4.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa la entidad de un Hotel en la base de datos MongoDB.
 * Esta clase se mapea a la colección "hoteles".
 */
@Document(collection = "hoteles")
public class Hotel {

    /**
     * El identificador único del hotel, generado por MongoDB.
     */
    @Id
    private String id;

    /**
     * El nombre del hotel.
     */
    private String nombre;

    /**
     * La ciudad donde se encuentra el hotel.
     */
    private String ciudad;

    /**
     * La clasificación en estrellas del hotel (e.g., 1 a 5).
     */
    private Integer estrellas;

    /**
     * El precio por noche de una habitación en el hotel.
     */
    private Double precioNoche;

    /**
     * Constructor por defecto.
     */
    public Hotel() {
    }

    /**
     * Constructor para crear un hotel con todos sus atributos.
     * @param nombre El nombre del hotel.
     * @param ciudad La ciudad del hotel.
     * @param estrellas La clasificación en estrellas.
     * @param precioNoche El precio por noche.
     */
    public Hotel(String nombre, String ciudad, Integer estrellas, Double precioNoche) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.precioNoche = precioNoche;
    }

    // Getters y Setters con Javadoc

    /**
     * @return El ID del hotel.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id El nuevo ID del hotel.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return El nombre del hotel.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre del hotel.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return La ciudad del hotel.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad La nueva ciudad del hotel.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return La clasificación en estrellas del hotel.
     */
    public Integer getEstrellas() {
        return estrellas;
    }

    /**
     * @param estrellas La nueva clasificación en estrellas.
     */
    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * @return El precio por noche.
     */
    public Double getPrecioNoche() {
        return precioNoche;
    }

    /**
     * @param precioNoche El nuevo precio por noche.
     */
    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }
}
