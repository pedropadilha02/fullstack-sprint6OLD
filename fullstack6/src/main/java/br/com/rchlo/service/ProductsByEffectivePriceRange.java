package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsByEffectivePriceRange {

    public List<Product> listProducts(BigDecimal minimumPrice, BigDecimal maximumPrice, List<Product> productList) {
        if (minimumPrice == null) throw new IllegalArgumentException("minimum price should not be null");
        if (maximumPrice == null) throw new IllegalArgumentException("maximum price should not be null");
        if (productList == null) throw new IllegalArgumentException("product list should not be null");

        List<Product> listFiltered = new ArrayList<>();

        for (Product product : productList) {
            if (getDecimal(product).compareTo(minimumPrice) >= 0 && (getDecimal(product)).compareTo(maximumPrice) <= 0) {
                listFiltered.add(product);
            }
        }

        return listFiltered;
    }

    private BigDecimal getDecimal(Product product) {
        return product.getDiscount() != null ? product.getPrice().subtract(product.getDiscount()) : product.getPrice();
    }

}
