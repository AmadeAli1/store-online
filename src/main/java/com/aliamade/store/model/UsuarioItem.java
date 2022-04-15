package com.aliamade.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(value = "usuarioitem")
public class UsuarioItem {
    @Id
    @Column("id")
    private Integer id;
    @Column("itemid")
    private Integer fk_item;
    @Column("userid")
    private Integer fk_user;
    @Column("status")
    private boolean status;

}
