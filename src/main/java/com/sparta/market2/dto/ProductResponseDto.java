package com.sparta.market2;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.content = product.getContent();
        this.price = product.getPrice();
        this.username = product.getUsername();
    }

}
