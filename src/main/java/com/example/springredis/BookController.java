package com.example.springredis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    
    @GetMapping("book")
    public ResponseEntity<BookModel> getBook(@RequestParam Long id) {
        BookModel byId = bookService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
    
}
