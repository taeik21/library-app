package com.group.libraryapp.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(Book book) {
        Loan loan = new Loan(this, book);

        loans.add(loan);
    }

    public void returnBook(String name) {
        Loan findLoan = loans.stream()
                .filter(loan -> loan.getBook().getName().equals(name))
                .filter(loan -> !loan.isReturned())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        findLoan.doReturn();
    }
}
