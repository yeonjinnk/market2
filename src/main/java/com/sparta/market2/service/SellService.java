package com.sparta.market2;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SellService {

    private final ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;
//    public SellService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//    public SellService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public com.sparta.market2.ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = (Product) productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> responseDtoList = new ArrayList<>();
        for(Product product : productList) {
            responseDtoList.add(new ProductResponseDto(product));
        }
        return responseDtoList;
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        product.update(requestDto);
        return new ProductResponseDto(product);
    }

    @Transactional
    public Long deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );
        product.delete(entityManager);
        return id;
    }

}
