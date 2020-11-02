package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

public class AfishaRepositoryTest {
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
    void shouldSave() {
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        afishaRepository.save(item1);
        afishaRepository.save(item2);
        afishaRepository.save(item3);

    }

    @Test
    void shouldFindAll() {
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        afishaRepository.findById(1);
        afishaRepository.findById(2);
        afishaRepository.findById(3);
        afishaRepository.findById(4);
        afishaRepository.findById(5);
        afishaRepository.findById(6);
        afishaRepository.findById(7);
        afishaRepository.findById(8);
        afishaRepository.findById(9);



    }

    @Test
    void shouldNotFindByIdShouldReturnNull() {
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        afishaRepository.findById(11);
        afishaRepository.findById(-1);
    }

    @Test
    void shouldRemoveById() {
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        afishaRepository.save(item1);
        afishaRepository.save(item2);
        afishaRepository.save(item3);
        afishaRepository.removeById(1);
        afishaRepository.removeById(2);
        afishaRepository.removeById(3);

    }

    @Test
    void shouldRemoveAll(){
        AfishaRepositiry afishaRepository = new AfishaRepositiry();
        Movie[] actual = afishaRepository.removeAll();
        Movie[] expected = new Movie[0];


        assertArrayEquals(expected, actual);


    }
}
