package com.example.springredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRespository bookRepository;

    @Cacheable(value = "Book", key = "#id")
    public BookModel findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
