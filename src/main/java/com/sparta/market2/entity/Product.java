package com.sparta.market2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;


@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "item") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;


    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();
    }

    public void update(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
    }
    // JPA를 사용하여 삭제하는 방법
    public void delete(EntityManager entityManager) {
        // 엔티티를 조회하여 삭제
        Product product = entityManager.find(Product.class, this.id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}