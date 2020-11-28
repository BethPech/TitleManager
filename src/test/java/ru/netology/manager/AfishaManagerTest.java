package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepositiry;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class AfishaManagerTest {
    @Mock
    private AfishaRepositiry repository;
    @InjectMocks
    private AfishaManager manager;
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
    public void setUp() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
    }

    @Test
    public void shouldFindAll() {
        Movie[] returned = new Movie[]{item1, item2, item3};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{item3, item2, item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindById() {
        int idToFind = 3;
        Movie returned = item3;
        doReturn(returned).when(repository).findById(3);
        manager.findById(idToFind);
        Movie expected = item3;
        Movie actual = repository.findById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByIdIfNotExists() {
        int idToFind = 13;
        Movie[] returned = new Movie[]{item1,item2,item3,item4,item5,item6,item7,item8,item9,item10};
        doReturn(returned).when(repository).findAll();
        manager.findById(idToFind);
        Movie[] expected = new Movie[]{item10,item9,item8,item7,item6,item5,item4,item3,item2,item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 1;
        Movie[] returned = new Movie[]{item1,item2,item3,item4,item5,item6,item7,item8,item9,item10};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{item10,item9,item8,item7,item6,item5,item4,item3,item2,item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 13;
        Movie[] returned = new Movie[]{item1,item2,item3,item4,item5,item6,item7,item8,item9,item10};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldRemoveAll() {
        doNothing().when(repository).removeAll();
        manager.removeAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddMoreThenLength() {
        Movie[] returned = new Movie[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddLessThenLength() {
        Movie[] returned = new Movie[]{item1, item2, item3, item4, item5, item6, item7, item8, item9};
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[]{item9, item8, item7, item6, item5, item4, item3, item2, item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

}
