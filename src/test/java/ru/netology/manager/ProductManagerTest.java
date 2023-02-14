package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    public ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Книга 1", 200, "Автор 1" );
    Product product2 = new Book(2, "Книга 2", 300, "Автор 2" );
    Product product3 = new Book(3, "Книга 3", 400, "Автор 3" );
    Product product4 = new SmartPhone(4, "Смартфон 1", 15_000, "Производитель 1" );
    Product product5 = new SmartPhone(5, "Смартфон 2", 20_000, "Производитель 2" );
    Product product6 = new SmartPhone(6, "Смартфон 3", 25_000, "Производитель 3" );

    @BeforeEach
    public void setup(){
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
    }

    @Test
    public void removeByID(){
        repository.removeByID(4);

        Product[] expected = new Product[]{product1, product2, product3, product5, product6};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundException(){
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeByID(7);
        });
    }
}
