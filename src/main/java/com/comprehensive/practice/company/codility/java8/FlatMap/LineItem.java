package com.comprehensive.practice.company.codility.java8.FlatMap;

import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {
    private Integer id;
    private String item;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;
}
