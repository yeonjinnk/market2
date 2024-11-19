package com.sparta.market.controller;

import com.sparta.market2.ProductRequestDto;
import com.sparta.market2.ProductResponseDto;
import com.sparta.market2.SellService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

public class SellController {
    private final JdbcTemplate jdbcTemplate;
    private final SellService sellService;

    //판매 게시글 작성
    @PostMapping("/post")
    public ProductResponseDto createSellPage(@RequestBody ProductRequestDto requestDto) {
        return sellService.createProduct(requestDto);
    }


    //판매 게시글 전체 리스트 조회
    @GetMapping("/post")
    public List<ProductResponseDto> getAllProducts() {
        return sellService.getAllProducts();
    }

    //판매 게시글 수정
    @PutMapping("/post/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) throws Exception {
        return sellService.updateProduct(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public Long deleteProduct(@PathVariable Long id) {

        return sellService.deleteProduct(id);

    }


}

