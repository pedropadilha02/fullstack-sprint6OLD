package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductsByColorTest {

    private ProductsByColor productsByColor;

    @BeforeEach
    void setUp() {
        productsByColor = new ProductsByColor();
    }

    @Test
    void shouldReturnOnlyTheCorrectColor() {
        List<Product> products = List.of(aTShirt(), aJacket());

        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, products);

        assertEquals(1, filteredProducts.size());

        Product product = filteredProducts.get(0);
        assertEquals(Color.WHITE, product.getColor());
        assertEquals("Jaqueta Puffer Juvenil Com Capuz Super Mario", product.getName());


    }

    @Test
    void shouldReturnAnEmptyListIfTheColorIsNotFound() {
        List<Product> products = List.of(aTShirt(), aJacket());

        List<Product> filteredProducts = productsByColor.filter(Color.GRAY, products);

        assertEquals(0, filteredProducts.size());
    }

    @Test
    void shouldAcceptAnEmptyList() {
        List<Product> emptyProducts = List.of();

        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, emptyProducts);

        assertEquals(0, filteredProducts.size());
    }

    @Test
    void shouldNotAcceptANullColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Product> emptyProducts = List.of();
            productsByColor.filter(null, emptyProducts);
        });
    }

    @Test
    void shouldNotAcceptANullList() {
        assertThrows(IllegalArgumentException.class, () -> {
            productsByColor.filter(Color.WHITE, null);
        });
    }

    private Product aTShirt() {
        return new Product(14124998L,
                "Camiseta Infantil Manga Curta Super Mario",
                "A Camiseta Infantil Manga Curta Super Mario Ã© confeccionada em malha macia e possui decote careca, mangas curtas e padronagem do Super Mario. Aposte na peÃ§a na hora de compor visuais geek divertidos.",
                "camiseta-infantil-manga-curta-super-mario-14124998_sku",
                "Nintendo",
                new BigDecimal("39.90"),
                new BigDecimal("5.0"),
                Color.BLUE,
                116,
                "https://static.riachuelo.com.br/RCHLO/14124998004/portrait/cd948d80fe8a1fdc873f8dca1f3c4c468253bf1d.jpg",
                Set.of(Size.SMALL, Size.MEDIUM));
    }

    private Product aJacket() {
        return new Product(13834193L,
                "Jaqueta Puffer Juvenil Com Capuz Super Mario",
                "A Jaqueta Puffer Juvenil Com Capuz Super Mario Ã© confeccionada em material sintÃ©tico. Possui estrutura ampla e modelo puffer, com capuz em pelÃºcia e bolsos frontais. Ideal para compor looks de inverno, mas sem perder o estilo. Combine com uma camiseta, calÃ§a jeans e tÃªnis colorido.",
                "jaqueta-puffer-juvenil-com-capuz-super-mario-13834193_sku",
                "Nintendo",
                new BigDecimal("199.90"),
                null,
                Color.WHITE,
                147,
                "https://static.riachuelo.com.br/RCHLO/13834193003/portrait/3107b7473df334c6ff206cd78d16dec86d7dfe9a.jpg",
                Set.of(Size.LARGE, Size.EXTRA_LARGE));
    }

}