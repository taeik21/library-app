package com.group.libraryapp.repository.loan;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.Loan;
import com.group.libraryapp.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Boolean existsByBookAndReturned(Book book, Boolean returned);

    Optional<Loan> findByMemberAndBookAndReturned(Member member, Book book, Boolean returned);
}
