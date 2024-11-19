package com.sparta.market2.repository;

import com.sparta.market2.dto.GetResponseDto;
import com.sparta.market2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByUsername(String username);

    @Query("SELECT new com.sparta.market2.dto.GetResponseDto(p.id, p.title, p.username, p.price) FROM Product p")
//    @Query("SELECT p.id, p.title, p.username, p.price FROM Product p")
    List<GetResponseDto> findAllButContent();
}


