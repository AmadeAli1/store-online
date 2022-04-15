package com.aliamade.store.repository;

import com.aliamade.store.model.Usuario;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {

    @Modifying
    @Query("INSERT INTO usuario values(:?1,:?2,:?3,:?4)")
    Mono<Integer> insert(String id, String email, String name, String image);

    @Modifying
    @Query("UPDATE usuario set email=:email, name =:name,image=:image where id=:userId ")
    Mono<Integer> update(String userId, String email, String name, String image);

    @Modifying
    @Query("DELETE from usuario where id=:id")
    Mono<Integer> delete(String id);
}
