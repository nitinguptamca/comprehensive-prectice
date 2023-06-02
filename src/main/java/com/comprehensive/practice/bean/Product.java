package com.comprehensive.practice.bean;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private int prodId;
    private String prodName;
    private LocalDate prodCreatedDate;
    private double prodRate;
}
