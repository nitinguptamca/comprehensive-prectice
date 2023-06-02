package com.comprehensive.practice.company.codility.java8.FlatMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private String invoice;
    private List<LineItem> lineItems;
    private BigDecimal total;
}
