# Layer Presentación
- Para las validaciones agregar dependencia
  - spring-boot-starter-validation
- @Validated es de Spring
- @Valid es de Jakarta
- application.properties Permite que se regresen los mensajes en el JSON si algo falla
  - server.error.include-binding-errors=always
- application.properties Permite que el mensaje de una exception se incluya en el JSON
  - server.error.include-message=always

# Probar validaciones
- Se pueden probar las validaciones removiendo el Mono del request
```
 public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest){...}
```
- Se regresa despues el Mono<CreateUserRequest>

