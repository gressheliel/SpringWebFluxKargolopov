# Configuración Inicial
- Dependencias
  - H2, Spring Data R2DBC, Spring Reactive Web

- En Spring WebFlux no se puede configurar la app para automaticamente crear las tablas en base al schema
- Se debe crear de manera manual.

- @Profile({"!prod & !production"}) public class H2ConsoleConfiguration
  - Disponible para ambientes que no son productivos
  - H2ConsoleConfiguration Inicia el server de la BD programáticamente

- Acceso a H2
  - http://localhost:2000/
  - BD=testDb, user=test, password=test
