package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class AfishaRepositoryTest {
    private AfishaRepositiry afishaRepository = new AfishaRepositiry();
        Movie item1 = new Movie(1, "1", "Бладшот", "Боевик");
        Movie item2 = new Movie(2, "2", "Вперёд", "мультфильм");
        Movie item3 = new Movie(3, "3", "Отель Белград", "комедия");
        Movie item4 = new Movie(4, "4", "Джентльмены", "боевик");
        Movie item5 = new Movie(5, "5", "Человек-невидимка", "ужасы");
        Movie item6 = new Movie(6, "6", "Тролли.Мировой тур", "мультфильм");
        Movie item7 = new Movie(7, "7", "Номер один", "комедия");
        Movie item8 = new Movie(8, "8", "Номер один", "комедия");
        Movie item9 = new Movie(9, "9", "Номер один", "комедия");


        @BeforeEach
                void setUp() {
            afishaRepository.save(item1);
            afishaRepository.save(item2);
            afishaRepository.save(item3);
            afishaRepository.save(item4);
            afishaRepository.save(item5);
            afishaRepository.save(item6);
            afishaRepository.save(item7);
            afishaRepository.save(item8);
            afishaRepository.save(item9);
        }
    @Test
    void shouldSave() {
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = new Movie[]{item1,item2, item3, item4, item5, item6, item7, item8,item9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = new Movie[]{item1,item2, item3, item4, item5, item6, item7, item8,item9};
        assertArrayEquals(expected, actual);
    }

    @Test
     void shouldFindById() {
        Movie actual = afishaRepository.findById(1);
        Movie expected = item1;
        assertEquals(expected, actual);

    }

    @Test
    void shouldNotFindByIdShouldReturnNull() {
        Movie actual = afishaRepository.findById(11);
        Movie expected = null;
        assertEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        Movie[] actual = afishaRepository.removeById(1);
        Movie[] expected = new Movie[]{item2, item3, item4, item5, item6, item7, item8,item9};
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldRemoveAll(){
        Movie[] actual = afishaRepository.removeAll();
        Movie[] expected = new Movie[0];


        assertArrayEquals(expected, actual);


    }
}
