package com.comprehensive.practice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
