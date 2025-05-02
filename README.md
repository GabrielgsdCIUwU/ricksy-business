# Ricksy Business

## Descripción General

El proyecto **Ricksy Business** es una simulación basada en el universo de la serie *Rick and Morty*. En este proyecto, se modela un sistema para gestionar una fiesta intergaláctica organizada por Rick Sánchez. La fiesta incluye la administración de recursos como ovnis, menús y packs de bienvenida, así como la gestión de los créditos de los invitados mediante tarjetas de crédito.

El objetivo principal del proyecto es simular cómo los invitados interactúan con los diferentes servicios disponibles en la fiesta, utilizando un sistema de pago y reserva automatizado.

## Conceptos Clave

1. **Tarjetas de Crédito**: Cada invitado tiene una tarjeta de crédito con un saldo inicial. Este saldo se utiliza para pagar los servicios ofrecidos en la fiesta.

2. **Servicios Disponibles**:
   - **Ovnis (Ufos)**: Los invitados pueden reservar un ovni para transportarse. Cada ovni tiene un costo fijo y está sujeto a disponibilidad.
   - **Packs de Bienvenida**: Incluyen artículos esenciales para disfrutar de la fiesta. Estos packs tienen un costo y un stock limitado.
   - **Rick Menús**: Menús especiales diseñados por Rick, disponibles para los invitados.

3. **Sistema de Gestión**:
   - **Receptivo**: Es el componente encargado de coordinar los servicios. Los invitados se registran en este sistema, y este se encarga de gestionar las reservas y pagos de los diferentes servicios.

## Flujo de Funcionamiento

1. Los invitados llegan a la fiesta con sus tarjetas de crédito.
2. Pueden interactuar con los servicios disponibles:
   - Reservar un ovni.
   - Comprar un pack de bienvenida.
   - Adquirir un Rick Menú.
3. El sistema verifica si el invitado tiene suficiente crédito y si hay disponibilidad del servicio solicitado.
4. Si se cumplen las condiciones, el sistema realiza la transacción y actualiza el saldo de la tarjeta y el stock del servicio.

## Cómo Entender el Proyecto

- **Clases Principales**:
  - `CreditCard`: Representa las tarjetas de crédito de los invitados.
  - `UfosPark`: Gestiona la flota de ovnis disponibles para la fiesta.
  - `CrystalExpender`: Administra los packs de bienvenida.
  - `RickMenu`: Maneja los menús especiales.
  - `Receptivo`: Coordina todos los servicios y asegura que los invitados   puedan acceder a ellos. 
      > A partir de la versión 2.0.0, esta clase sigue el patrón Singleton. Ya no se instancia directamente con `new`, 
      > sino que se accede mediante `Receptivo.getInstance()`.

- **Interacción**: Cada clase tiene métodos que permiten realizar acciones como pagar, reservar o registrar servicios. El flujo principal del programa se encuentra en la clase `App`, que simula la llegada de los invitados y su interacción con los servicios.

## Objetivo del Proyecto

El proyecto tiene un enfoque educativo y está diseñado para practicar conceptos de programación orientada a objetos, como herencia, interfaces y polimorfismo, además de la gestión de recursos y la simulación de un sistema real.

## Cómo Ejecutarlo

1. Asegúrate de tener instalado Java 21 y Maven.
2. Clona el repositorio
3. Usa Maven para compilar y ejecutar el proyecto:
- ```sh
   mvn compile
    ```
    para compilar.

- ```sh
    java -jar ./target/ricksy-X.Y.Z.jar
   ```
    para ejecutar la simulación.
4. Observa la salida en la consola para ver cómo los invitados interactúan con los servicios.

## Licencia

Este proyecto está bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente, siempre que incluyas el aviso de copyright original.

¡Disfruta explorando el universo de Ricksy Business!