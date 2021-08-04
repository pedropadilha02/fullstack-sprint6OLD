package br.com.rchlo.main;

import java.util.List;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsSortedByCode;

public class ProductsSortedByCodeMain {
    public static void main(String[] args) {
        ProductsSortedByCode productsSortedByCodeFilter = new ProductsSortedByCode();
        List<Product> allProducts = ProductRepository.all();

        productsSortedByCodeFilter.productsSorted(allProducts);


    }
}
