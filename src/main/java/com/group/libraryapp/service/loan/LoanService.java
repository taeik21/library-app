package com.group.libraryapp.service.loan;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.Loan;
import com.group.libraryapp.domain.Member;
import com.group.libraryapp.dto.BookLoanRequest;
import com.group.libraryapp.dto.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.loan.LoanRepository;
import com.group.libraryapp.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void loan(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        if (loanRepository.existsByBookAndReturned(book, false)) {
            throw new IllegalArgumentException("이미 대여 중인 책입니다.");
        }

        Member member = memberRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        member.loanBook(book);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        Member member = memberRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        member.returnBook(request.getBookName());
    }
}
