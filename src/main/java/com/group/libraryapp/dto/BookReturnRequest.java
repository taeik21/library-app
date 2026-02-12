package com.group.libraryapp.dto;

import lombok.Data;

@Data
public class BookReturnRequest {
    private String userName;

    private String bookName;
}
