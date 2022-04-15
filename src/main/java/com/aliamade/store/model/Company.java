package com.aliamade.store.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table("company")
public class Company {
    @Id
    @Column("id")
    private Integer id;
    @Column("email")
    private String email;
    @Column("name")
    private String name;
    @Column("imagelogourl")
    private String imageUrl;
    @Column("image")
    private byte[] image;
}
