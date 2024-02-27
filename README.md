# protecNet: Plataforma Anti-Phishing

## Descripción del Proyecto

protecNet es una plataforma anti-phishing que utiliza inteligencia artificial para analizar múltiples URLs en busca de posibles amenazas. La plataforma permite a los usuarios enviar URLs sospechosas, que son luego analizadas por una IA. Si se detecta un posible phishing, se crea un ticket que es revisado por un analista.

## Modelo de Datos

### Tickets
- Estado actual del ticket (pendiente, aceptado, cerrado).
- URL sospechosa.
- Fecha de Creación.
- Marca Afectada.
- Correo del Proveedor.
- Correo del Cliente (Marca Afectada).

## Características Principales

- **Análisis de URLs:** La inteligencia artificial de protecNet es capaz de analizar múltiples URLs para detectar posibles amenazas de phishing.

- **Generación de Tickets:** En caso de detectar un posible phishing, se genera un ticket con información relevante como la URL, la fecha de creación, la marca afectada, el correo del proveedor y el correo del cliente.

- **Validación por Analistas:** Los analistas revisan los tickets y validan si la URL es maliciosa. En caso afirmativo, el ticket es aceptado y se notifica automáticamente al proveedor y a la marca afectada.

- **Monitorización de Páginas:** Los analistas monitorizan la página maliciosa hasta que se cae, momento en el cual se cierra el ticket y se notifica a la empresa afectada que la página ha sido dada de baja.


## Clases Principales

### Ticket

- **Estado:** Estado actual del ticket (pendiente, aceptado, cerrado).
- **URL:** URL sospechosa.
- **Fecha de Creación:** Fecha en la que se creó el ticket.
- **Marca Afectada:** Marca asociada a la URL con posible phishing.
- **Correo del Proveedor:** Correo del proveedor de la página maliciosa.
- **Correo del Cliente (Marca Afectada):** Correo de la marca afectada.

### IA

La clase `IA` (Inteligencia Artificial) se encarga del análisis de múltiples URLs en busca de posibles amenazas de phishing. Utiliza lógica de análisis y, en caso de detectar phishing, crea un nuevo ticket. También interactúa con la base de datos MongoDB para obtener información adicional, como el correo del cliente (marca afectada).

```java
@Service
public class IA {
    @Autowired
    private MongoTemplate mongoTemplate; // Inyección de dependencia para interactuar con MongoDB

    @Autowired
    private TicketRepository ticketRepository; // Repositorio para acceder a los datos de Ticket en MongoDB

    
}
```
## Controladores y Servicios

### Controladores

- Controlador de Usuarios: Maneja operaciones CRUD y búsquedas de usuarios.
- Controlador de Productos: Maneja operaciones CRUD y búsquedas de productos.
- Controlador de Pedidos: Maneja operaciones CRUD y búsquedas de pedidos.
- Controlador de Tickets: Maneja operaciones CRUD y búsquedas de tickets.

### Servicios

- Servicio de Usuarios: Provee lógica de negocio para operaciones relacionadas con usuarios.
- Servicio de Productos: Provee lógica de negocio para operaciones relacionadas con productos.
- Servicio de Pedidos: Provee lógica de negocio para operaciones relacionadas con pedidos.
- Servicio de Tickets: Provee lógica de negocio para operaciones relacionadas con tickets.


## Desarrolladores

- **Sergio Gonzalez**
- **Francisco**
- **Juan paulo**
- **Luisa**
