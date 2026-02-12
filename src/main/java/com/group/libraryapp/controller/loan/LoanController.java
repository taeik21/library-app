package com.group.libraryapp.controller.loan;

import com.group.libraryapp.dto.BookLoanRequest;
import com.group.libraryapp.dto.BookReturnRequest;
import com.group.libraryapp.service.loan.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        loanService.loan(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        loanService.returnBook(request);
    }
}
