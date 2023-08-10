package ru.netology.javaqa.domain;

import org.junit.jupiter.api.Assertions;
import ru.netology.javaqa.repository.ShopRepository;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "хлеб", 38);
    Product product2 = new Product(222, "булка", 44);
    Product product3 = new Product(3, "картошкa", 50);

    @Test
    public void ShouldThrowException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void ShouldRemoveProductById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product2, product3};
        Product[] actual = repo.removeById(11);
        Assertions.assertArrayEquals(expected, actual);
    }
}
