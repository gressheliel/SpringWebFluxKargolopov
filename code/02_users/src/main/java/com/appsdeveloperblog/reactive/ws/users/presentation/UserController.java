package com.appsdeveloperblog.reactive.ws.users.presentation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public Mono<ResponseEntity<UserRest>> createUser(@RequestBody @Valid Mono<CreateUserRequest> createUserRequest){
        return createUserRequest
                .map(request -> new UserRest(UUID.randomUUID(), request.getFirstName(), request.getLastName(), request.getEmail()))
                .map(userRest -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .location(URI.create("/users/" + userRest.getId()))  //Es un Header
                        .body(userRest));
    }

    @GetMapping("/{userId}")
    public Mono<UserRest> getUser(@PathVariable UUID userId){
        return Mono.just(new UserRest(userId, "Juan", "Perez", "mail@mail.com"));
    }

    @GetMapping()
    public Flux<UserRest> getUsers(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                   @RequestParam(value = "limit", defaultValue = "50") int limit){
        return Flux.just(new UserRest(UUID.randomUUID(), "Ian", "Herrera", "ian@mail.com"),
                         new UserRest(UUID.randomUUID(), "Josue", "Herrera", "josue@mail.com"),
                         new UserRest(UUID.randomUUID(), "Daniel", "Herrera", "dany@mail.com"));
    }
}
