package org.example.reto4.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hoteles")
public class Hotel {

    @Id
    private String id;

    private String nombre;
    private String ciudad;
    private Integer estrellas;
    private Double precioNoche;

    public Hotel() {
    }

    public Hotel(String nombre, String ciudad, Integer estrellas, Double precioNoche) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.precioNoche = precioNoche;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }
}

