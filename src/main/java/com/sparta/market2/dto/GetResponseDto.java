package com.sparta.market2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetResponseDto {
    private int id;
    private String title;
    private String username;
    private int price;

}
