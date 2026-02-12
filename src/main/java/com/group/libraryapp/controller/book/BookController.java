package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.BookCreateRequest;
import com.group.libraryapp.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public void createBook(@RequestBody BookCreateRequest request) {
        bookService.saveBook(request);
    }
}
