package com.group.libraryapp.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Loan {
    @Id @GeneratedValue
    @Column(name = "loan_id")
    private Long id;

    private boolean returned;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Loan(Member member, Book book) {
        this.returned = false;
        this.member = member;
        this.book = book;
    }

    public void doReturn() {
        returned = true;
    }
}
