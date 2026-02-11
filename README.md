# Proyecto de Gestión de Hoteles y Reservas (Reto4)

Este proyecto es una API RESTful desarrollada con Spring Boot para gestionar hoteles y sus reservas. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre los hoteles y crear/listar reservas asociadas a ellos.

## Tecnologías

- Java 17
- Spring Boot 3.2.5
- MongoDB
- Maven
- Spring Security

---

## Recursos y Endpoints

La API expone dos recursos principales: `Hoteles` y `Reservas`.

### 1. Hoteles (`/hoteles`)

Este recurso gestiona la información de los hoteles disponibles.

#### `GET /hoteles`
Recupera una lista de todos los hoteles registrados.

**Ejemplo de respuesta:**
```json
[
    {
        "id": "60c72b2f9b1d8c2b8f8b4567",
        "nombre": "Hotel Sol y Mar",
        "ciudad": "Cartagena",
        "estrellas": 5,
        "precioNoche": 250.00
    },
    {
        "id": "60c72b2f9b1d8c2b8f8b4568",
        "nombre": "Hotel Montaña Azul",
        "ciudad": "Medellín",
        "estrellas": 4,
        "precioNoche": 150.00
    }
]
```

---

#### `GET /hoteles/{id}`
Obtiene los detalles de un hotel específico por su ID.

**Parámetros de ruta:**
- `id` (String): El ID del hotel.

**Ejemplo de respuesta (200 OK):**
```json
{
    "id": "60c72b2f9b1d8c2b8f8b4567",
    "nombre": "Hotel Sol y Mar",
    "ciudad": "Cartagena",
    "estrellas": 5,
    "precioNoche": 250.00
}
```

**Respuesta de error (404 Not Found):**
```json
{
    "error": "Hotel 60c72b2f9b1d8c2b8f8b4560 no encontrado"
}
```

---

#### `POST /hoteles`
Crea un nuevo hotel. **Requiere rol de `ADMIN`.**

**Cuerpo de la solicitud (Request Body):**
```json
{
    "nombre": "Hotel Vista Verde",
    "ciudad": "Salento",
    "estrellas": 3,
    "precioNoche": 120.50
}
```

**Ejemplo de respuesta (200 OK):**
```json
{
    "id": "60c72b3a9b1d8c2b8f8b4569",
    "nombre": "Hotel Vista Verde",
    "ciudad": "Salento",
    "estrellas": 3,
    "precioNoche": 120.50
}
```

---

#### `PUT /hoteles/{id}`
Actualiza la información de un hotel existente. **Requiere rol de `ADMIN`.**

**Parámetros de ruta:**
- `id` (String): El ID del hotel a actualizar.

**Cuerpo de la solicitud (Request Body):**
```json
{
    "nombre": "Hotel Vista Verde Actualizado",
    "ciudad": "Salento",
    "estrellas": 4,
    "precioNoche": 130.00
}
```

**Ejemplo de respuesta (200 OK):**
```json
{
    "id": "60c72b3a9b1d8c2b8f8b4569",
    "nombre": "Hotel Vista Verde Actualizado",
    "ciudad": "Salento",
    "estrellas": 4,
    "precioNoche": 130.00
}
```

---

### 2. Reservas (`/reservas`)

Este recurso gestiona las reservas de los hoteles.

#### `POST /reservas`
Crea una nueva reserva para un hotel.

**Parámetros de la solicitud (Request Param):**
- `hotelId` (String): El ID del hotel para el que se crea la reserva.

**Cuerpo de la solicitud (Request Body):**
```json
{
    "cliente": "Juan Pérez",
    "fechaEntrada": "2024-08-10",
    "fechaSalida": "2024-08-15"
}
```

**Ejemplo de respuesta (200 OK):**
```json
{
    "id": "61c72b3a9b1d8c2b8f8b4570",
    "cliente": "Juan Pérez",
    "fechaEntrada": "2024-08-10",
    "fechaSalida": "2024-08-15",
    "hotelId": "60c72b2f9b1d8c2b8f8b4567"
}
```

**Respuesta de error (404 Not Found si el hotel no existe):**
```json
{
    "error": "Hotel 60c72b2f9b1d8c2b8f8b4567 no encontrado"
}
```

---

#### `GET /reservas`
Recupera una lista de todas las reservas realizadas.

**Ejemplo de respuesta:**
```json
[
    {
        "id": "61c72b3a9b1d8c2b8f8b4570",
        "cliente": "Juan Pérez",
        "fechaEntrada": "2024-08-10",
        "fechaSalida": "2024-08-15",
        "hotelId": "60c72b2f9b1d8c2b8f8b4567"
    },
    {
        "id": "61c72b3a9b1d8c2b8f8b4571",
        "cliente": "Ana García",
        "fechaEntrada": "2024-09-01",
        "fechaSalida": "2024-09-05",
        "hotelId": "60c72b2f9b1d8c2b8f8b4568"
    }
]
```

---

## Modelos de Datos

### Hotel
```java
public class Hotel {
    private String id;
    private String nombre;
    private String ciudad;
    private Integer estrellas;
    private Double precioNoche;
}
```

### Reserva
```java
public class Reserva {
    private String id;
    private String cliente;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String hotelId; // ID del hotel asociado
}
```

---

## Seguridad

La API utiliza Spring Security para proteger los endpoints de creación y actualización de hoteles. Para acceder a ellos, el usuario debe estar autenticado y tener el rol `ADMIN`.

- `POST /hoteles` - Requiere `ROLE_ADMIN`
- `PUT /hoteles/{id}` - Requiere `ROLE_ADMIN`

Los demás endpoints son de acceso público.
