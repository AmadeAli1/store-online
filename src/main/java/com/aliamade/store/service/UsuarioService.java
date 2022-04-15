package com.aliamade.store.service;

import com.aliamade.store.model.Usuario;
import com.aliamade.store.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Mono<Usuario> save(Usuario usuario) {
        return this.repository.insert(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getImage())
                .flatMap(status -> {
                    System.out.println("IN");
                    if (status == 1){
                        System.out.println("TRUE::::::");
                        return findUser(usuario.getId());
                    }
                    return Mono.error(new RuntimeException("Erro ao criar a conta"));
                });
    }

    public Mono<Usuario> update(String id, Usuario usuario) {
        Mono<Usuario> user = this.findUser(id);
        Mono<Integer> updateStatus = user.flatMap(usuario1 -> repository.update(id, usuario.getName(), usuario.getEmail(), usuario.getImage()));
        return updateStatus.flatMap(status -> {
            if (status == 1)
                return findUser(id);
            return Mono.empty();
        });
    }

    public Flux<Usuario> findAll() {
        return this.repository.findAll();
    }

    public Mono<Usuario> findUser(String id) {
        return this.repository.findById(id);
        /**
         * .switchIfEmpty(new Mono<>() {
         *             @Override
         *             public void subscribe(CoreSubscriber<? super Usuario> actual) {
         *                 throw new RuntimeException("Usuario nao encontrado");
         *             }
         *         })
         */
    }

    public Mono<Integer> delete(String id) {
        return this.repository.delete(id);
    }

}
