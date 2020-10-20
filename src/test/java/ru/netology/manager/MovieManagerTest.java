package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class MovieManagerTest {

    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();
        int idToAdd = 1;
        MovieManager.add("8", "8", "Довод", "боевик");

        MovieManager[] actual = manager.getAll();
        MovieManager[] expected = new MovieManager[]{"Довод","Номер один","Тролли.Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперёд","Бладшот"};


//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);

    }

}
