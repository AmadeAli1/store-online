package com.aliamade.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(value = "item")
public class Item {
    @Id
    private Integer id;
    @Column("name")
    private String name;
    @Column("category")
    private String category;
    @Column("price")
    private Float price;
    @Column("date")
    private Date date;
    @Column("imageurl")
    private String imageUrl;
    @Column("image")
    private byte[] image;
    @Column("companyid")
    private Integer fk_company;
    @Column("categoryid")
    private Integer fk_category;

}
