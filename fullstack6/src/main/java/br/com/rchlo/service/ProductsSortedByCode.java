package br.com.rchlo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.rchlo.domain.Product;

public class ProductsSortedByCode {

    public void productsSorted(List<Product> productList) {
        List<Product> sortedList = new ArrayList<>(productList);

        Collections.sort(sortedList);

        for (Product product : sortedList) {
            System.out.println(product.getCode() + " - " + product.getName());
        }

    }
}
