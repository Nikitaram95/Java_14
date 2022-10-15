package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    @Test
    void searchByNameBook() {
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Agata");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameSmartphone() {
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Lee");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByVendor() {
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{four};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Huawei");

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdIfExists() {
        int idToRemove = 4;
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Smartphone(4, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        manager.removeById(idToRemove);

        Product[] expected = new Product[]{third, second, first};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        int id = 4;
        Product first = new Book(1, "Make", 499, "Lee");
        Product second = new Book(2, "Marple", 390, "Agata");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");


        manager.add(first);
        manager.add(second);
        manager.add(third);

        assertThrows(NotFoundException.class, () -> manager.removeById(id));

        Product[] expected = new Product[]{third, second, first};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
}