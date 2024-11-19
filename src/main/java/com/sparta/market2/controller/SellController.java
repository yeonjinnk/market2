package com.sparta.market2.controller;

import com.sparta.market2.dto.DeleteResponseDto;
import com.sparta.market2.dto.GetResponseDto;
import com.sparta.market2.dto.ProductRequestDto;
import com.sparta.market2.dto.ProductResponseDto;
import com.sparta.market2.entity.Product;
import com.sparta.market2.repository.ProductRepository;
import com.sparta.market2.service.SellService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

public class SellController {
    private final JdbcTemplate jdbcTemplate;
    private final SellService sellService;
    private final ProductRepository productRepository;

    //판매 게시글 작성
    @PostMapping("/post")
    public ProductResponseDto createSellPage(@RequestBody ProductRequestDto requestDto) {
        return sellService.createProduct(requestDto);
    }


    //판매 게시글 전체 리스트 조회
    @GetMapping("/post")
    public List<GetResponseDto> getAllProducts() {
        return sellService.getAllProducts();
    }

    //판매 게시글 수정
    @PutMapping("/post/{id}")
    public ProductResponseDto updateProduct(@PathVariable String id, @RequestBody ProductRequestDto requestDto) throws Exception {
        int intId = Integer.parseInt(id);
        System.out.println("id: " + intId + "requestDto: " + requestDto);
        System.out.println("title: " + requestDto.getTitle() + "content: " + requestDto.getContent() + "price: " + requestDto.getPrice());
        System.out.println("updateProduct 호출됨!");
//        Product product = sellService.findProduct(intId);
//        requestDto.setContent(requestDto.getContent() == null ? product.getContent() : requestDto.getContent());
//        requestDto.setTitle(requestDto.getTitle() == null ? product.getTitle() : requestDto.getTitle());
//        requestDto.setPrice(requestDto.getPrice() == 0 ? product.getPrice() : requestDto.getPrice());
        return sellService.updateProduct(intId, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public DeleteResponseDto deleteProduct(@PathVariable int id) {

        return sellService.deleteProduct(id);

    }


}

