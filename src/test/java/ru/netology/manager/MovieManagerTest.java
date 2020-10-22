package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    Movie item1 = new Movie(1, "1", "Бладшот", "Боевик");
    Movie item2 = new Movie(2, "2", "Вперёд", "мультфильм");
    Movie item3 = new Movie(3, "3", "Отель Белград", "комедия");
    Movie item4 = new Movie(4, "4", "Джентльмены", "боевик");
    Movie item5 = new Movie(5, "5", "Человек-невидимка", "ужасы");
    Movie item6 = new Movie(6, "6", "Тролли.Мировой тур", "мультфильм");
    Movie item7 = new Movie(7, "7", "Номер один", "комедия");
    Movie item8 = new Movie(8, "8", "Номер один", "комедия");
    Movie item9 = new Movie(9, "9", "Номер один", "комедия");
    Movie item10 = new Movie(10, "10", "Номер один", "комедия");
    Movie item11 = new Movie(11, "11", "Номер один", "комедия");


    @BeforeEach
    void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);


    }

    @Test
    public void shouldAddMoviesEqualManagerLength() {
        manager.add(item10);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        assertArrayEquals(expected, actual);
    }


    MovieManager manager1 = new MovieManager(5);

    @BeforeEach
    void setup1() {
        manager1.add(item1);
        manager1.add(item2);
        manager1.add(item3);
        manager1.add(item4);
        manager1.add(item5);
        manager1.add(item6);
        manager1.add(item7);
        manager1.add(item8);
        manager1.add(item9);

    }

    @Test
    public void shouldAddLastItems() {
        manager1.add(item10);
        Movie[] actual = manager1.getAllLastItems();
        Movie[] expected = new Movie[]{item10, item9, item8, item7, item6};
        assertArrayEquals(expected, actual);
    }

}



