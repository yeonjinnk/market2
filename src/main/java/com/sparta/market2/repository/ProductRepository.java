package com.sparta.market2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<com.sparta.market2.Product, Long> {
    List<com.sparta.market2.Product> findAllByUsername(String username);

}


