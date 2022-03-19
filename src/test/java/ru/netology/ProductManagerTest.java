package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Notfoundexcep;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Три товарища", 302, "Эрих Мария Ремарк");
    private Book secondBook = new Book(2, "Мизери", 839, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Великий Гэтсби", 450, "Фрэнсис Скотт Фицджеральд");
    private Smartphone firstSmart = new Smartphone(4, "Айфон 13 ПРО МАХ", 197990, "Самсунг");
    private Smartphone secondSmart = new Smartphone(5, "Айфон 13 ПРО МАХ", 197990, "Эйпл");
    private Smartphone thirdSmart = new Smartphone(6, "Редми Ноут 10", 25990, "Ксяоми");
    private Smartphone fourthSmart = new Smartphone(7, "Редми Ноут 9", 19990, "Ксяоми");


    @BeforeEach
    void add() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstSmart);
        manager.add(secondSmart);
        manager.add(thirdSmart);
        manager.add(fourthSmart);
    }

    @Test
    void shouldDeleteProductFound() {
        manager.removeById(1);
    }

    @Test
    void shouldNoDeleteNoProductFound() {
        assertThrows(Notfoundexcep.class, () -> {
            manager.removeById(-1);
        });
    }
}