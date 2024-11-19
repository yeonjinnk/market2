package com.sparta.market2.service;

import com.sparta.market2.dto.DeleteResponseDto;
import com.sparta.market2.dto.GetResponseDto;
import com.sparta.market2.entity.Product;
import com.sparta.market2.repository.ProductRepository;
import com.sparta.market2.dto.ProductRequestDto;
import com.sparta.market2.dto.ProductResponseDto;
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

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    public List<GetResponseDto> getAllProducts() {
        List<GetResponseDto> getProductList = productRepository.findAllButContent();
//        List<Product> productList = productRepository.findAll();
        List<GetResponseDto> responseDtoList = new ArrayList<>();
        for(GetResponseDto product : getProductList) {
            responseDtoList.add(product);
        }
        System.out.println(responseDtoList);
        return responseDtoList;
    }

    @Transactional
    public ProductResponseDto updateProduct(int id, ProductRequestDto requestDto) throws Exception {
        System.out.println("service에서 updateProduct");
        System.out.println("id: " + id + "requestDto: " + requestDto);
        System.out.println("title: " + requestDto.getTitle() + "content: " + requestDto.getContent() + "price: " + requestDto.getPrice());
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        product.update(requestDto);
        return new ProductResponseDto(product);
    }

    @Transactional
    public DeleteResponseDto deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );
        productRepository.deleteById(id);
        DeleteResponseDto responseDto = new DeleteResponseDto("삭제완료");
        return responseDto;
    }

    @Transactional
    public Product findProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.") );
        return product;
    }
}
