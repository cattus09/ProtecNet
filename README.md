# protecNet: Plataforma Anti-Phishing

## Descripción del Proyecto

protecNet es una plataforma anti-phishing que utiliza inteligencia artificial para analizar múltiples URLs en busca de posibles amenazas. La plataforma permite a los usuarios enviar URLs sospechosas, que son luego analizadas por una IA. Si se detecta un posible phishing, se crea un ticket que es revisado por un analista.

## Características Principales

- **Análisis de URLs:** La inteligencia artificial de protecNet es capaz de analizar múltiples URLs para detectar posibles amenazas de phishing.

- **Generación de Tickets:** En caso de detectar un posible phishing, se genera un ticket con información relevante como la URL, la fecha de creación, la marca afectada y el correo del proveedor de la página maliciosa.

- **Validación por Analistas:** Los analistas revisan los tickets y validan si la URL es maliciosa. En caso afirmativo, el ticket es aceptado y se notifica automáticamente al proveedor y a la marca afectada.

- **Monitorización de Páginas:** Los analistas monitorizan la página maliciosa hasta que se cae, momento en el cual se cierra el ticket y se notifica a la empresa afectada que la página ha sido dada de baja.

## Clases Principales

### Ticket

- **Estado:** Estado actual del ticket (pendiente, aceptado, cerrado).
- **URL:** URL sospechosa.
- **Fecha de Creación:** Fecha en la que se creó el ticket.
- **Marca Afectada:** Marca asociada a la URL con posible phishing.
- **ID:** Identificador único del ticket.
- **CorreoProveedor:** Correo del proveedor de la página maliciosa.

### IA

- **AnálisisURLs:** Capacidad para recibir y analizar múltiples URLs.

## Uso

1. **Envío de URLs:** Los usuarios pueden enviar URLs sospechosas a la plataforma para su análisis.
2. **Generación de Tickets:** En caso de detectar phishing, se genera automáticamente un ticket.
3. **Validación por Analistas:** Los analistas revisan y validan los tickets.
4. **Notificaciones:** Se envían notificaciones automáticas a los proveedores y marcas afectadas.
5. **Monitorización y Cierre:** Los analistas monitorizan la página maliciosa hasta su caída y cierran el ticket.


## Desarrolladores

- **Sergio Gonzalez**
- **Francisco**
- **Juan paulo**
- **Luisa**
