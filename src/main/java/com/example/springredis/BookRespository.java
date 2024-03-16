package com.example.springredis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<BookModel, Long>{

}
