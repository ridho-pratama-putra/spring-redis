package com.example.springredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRespository bookRepository;
    public final RedisTemplate<String, String> redisTemplate;

    @Cacheable(value = "Book", key = "#id")
    public BookModel findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public String publishMessage(Long id) {
        redisTemplate.convertAndSend("book requested", "book requested " + id.toString());
        return "published";
    }
}
