## NEST QUEST
========================

## Context
NestQuest es una plataforma diseñada para simplificar la organización y planificación de viajes personalizados, basándose en una arquitectura cliente-servidor sólida. Este proyecto innovador conecta a los usuarios con una amplia gama de opciones de alojamiento a través de una interfaz intuitiva y fácil de usar.

Una de las características distintivas de NestQuest es su capacidad para gestionar reservas de alojamiento de manera eficiente y segura. El sistema recopila las preferencias de viaje de los usuarios y presenta opciones de alojamiento personalizadas, garantizando una experiencia adaptada a las necesidades individuales de cada cliente.

Además, NestQuest implementa tecnología de acceso mediante códigos QR en las puertas de los alojamientos, proporcionando un método seguro y sin complicaciones para acceder a las habitaciones reservadas. Esto no solo agiliza el proceso de check-in, sino que también mejora la seguridad y la comodidad para los huéspedes.

El servidor central de NestQuest se conecta a una API de proveedores de hoteles para acceder a datos relevantes sobre alojamientos y habitaciones. Dos tipos de clientes interactúan con el servidor: uno para controlar accesos y seguridad en el hotel, y otro para los huéspedes, ofreciendo una interfaz intuitiva para acceder a servicios y realizar reservas.

Las API del servidor han sido diseñadas para gestionar usuarios, consultar reservas, realizar nuevas reservas y buscar opciones de alojamiento. Además, NestQuest utiliza tecnologías como JavaMail para enviar confirmaciones de reserva por correo electrónico y ZXing para generar códigos QR.

Con una interfaz gráfica de usuario desarrollada en Swing, NestQuest proporciona una experiencia de usuario intuitiva y agradable. Los usuarios pueden explorar fácilmente las opciones de alojamiento, ver detalles y realizar reservas de manera rápida y sencilla.

## Usage
El proyecto está dividido en tres carpetas cada una con su propio build y son ejecutables individualmente. Para usar la aplicación, primero se debe ejecutar el servidor (server-book y server-door). Eso permitirá el establecimiento de un servidor esperando a la llamada de los clientes, bien client-door o bien client-book.

El client-door está orientado a la comprobación de reservas mediante QR lo cual permite acceder a los alojamientos. Por otra parte, el client-book está orientado a la reserva y búsqueda de esos alojamientos.
