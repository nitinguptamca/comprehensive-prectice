package com.comprehensive.practice.company.codility.java8;

import com.comprehensive.practice.bean.Product;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductLocalDateSortingUsingComparator {

    public static void main(String[] args) throws ParseException {

        // 1. products
        Product product1 = new Product(1, "Cooker", LocalDate.of(2022, Month.MAY, 31), 13750.0);
        Product product2 = new Product(2, "Sofa bed", LocalDate.of(2019, Month.NOVEMBER, 2), 11750.0);
        Product product3 = new Product(3, "Fridge", LocalDate.of(2021, Month.MARCH, 27), 12750.0);
        Product product4 = new Product(4, "Cupboard", LocalDate.of(2020, Month.APRIL, 30), 11525.0);
        Product product5 = new Product(5, "Utensils", LocalDate.of(2022, Month.JUNE, 1), 17050.0);


        // 1.1 List of Products
        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);


        // 1.2 print to console
        System.out.println("Before sorting :- \n");
        for (Product prod : products) {
            System.out.println(prod);
        }


        // 2. Ascending-order sorting
        Collections.sort(products, new ProductSortingComparator());


        // 2.1 print to console - ascending order
        System.out.println("\n\nAscending-order sorting on the basis of LocalDate :- \n");
        for (Product prod : products) {
            System.out.println(prod);
        }


        // 3. Descending-order sorting
        Collections.sort(products, (new ProductSortingComparator()).reversed());


        // 3.1 print to console - descending order
        System.out.println("\n\nDescending-order sorting on the basis of LocalDate :- \n");
        for (Product prod : products) {
            System.out.println(prod);
        }
    }
}


class ProductSortingComparator implements Comparator<Product> {

    @Override
    public int compare(Product prod1, Product prod2) {
        return prod1.getProdCreatedDate().compareTo(prod2.getProdCreatedDate());
    }
}
