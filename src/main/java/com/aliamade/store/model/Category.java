package com.aliamade.store.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "category")
public record Category(
        @Id @Column("id") Integer id, @Column("name") String name
) {
    public Category {
    }
}
