package com.aliamade.store.restcontroller;

import com.aliamade.store.model.Usuario;
import com.aliamade.store.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {
    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Usuario> insert( @RequestBody Usuario usuario) {
        return this.service.save(usuario);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> update(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        return this.service.update(id, usuario)
                .flatMap((Function<Usuario, Mono<ResponseEntity<Usuario>>>) update -> {
                    if (usuario != null) {
                        return Mono.just(new ResponseEntity<>(update, HttpStatus.OK));
                    }
                    return Mono.just(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
                });
    }

    @GetMapping
    public Flux<Usuario> allUsers() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> getUser(@PathVariable("id") String id) {
        return this.service.findUser(id).flatMap(new Function<Usuario, Mono<ResponseEntity<Usuario>>>() {
            @Override
            public Mono<ResponseEntity<Usuario>> apply(Usuario usuario) {
                if (usuario != null) {
                    return Mono.just(new ResponseEntity<>(usuario, HttpStatus.OK));
                }
                return Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
        });
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable("id") String id) {
        return this.service.delete(id).
                flatMap(new Function<Integer, Mono<ResponseEntity<String>>>() {
                    @Override
                    public Mono<ResponseEntity<String>> apply(Integer status) {
                        if (status == 1) {
                            return Mono.just(new ResponseEntity<>("Usuario removido com sucesso", HttpStatus.OK));
                        }
                        return Mono.just(new ResponseEntity<>("O usuario nao existe", HttpStatus.NOT_FOUND));
                    }
                });

    }

}
