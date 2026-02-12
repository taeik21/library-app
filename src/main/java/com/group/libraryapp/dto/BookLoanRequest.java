package com.group.libraryapp.dto;

import lombok.Data;

@Data
public class BookLoanRequest {
    private String userName;

    private String bookName;

    public BookLoanRequest(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }
}
