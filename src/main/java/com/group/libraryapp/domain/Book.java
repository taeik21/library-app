package com.group.libraryapp.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    public Book(String name) {
        this.name = name;
    }
}
