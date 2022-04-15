package com.aliamade.store.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(value = "usuario")
public class Usuario {
    @Id
    @NotNull
    @NotBlank
    private String id;

    @Column("email")
    @NotNull
    @NotBlank
    private String email;

    @Column("name")
    @NotNull
    @NotBlank
    private String name;

    @Column("image")
    @NotNull
    @NotBlank
    private String image;
}
