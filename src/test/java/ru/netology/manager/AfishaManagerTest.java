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
    private Movie item1 = new Movie(1, "1", "Бладшот", "Боевик");
    private Movie item2 = new Movie(2, "2", "Вперёд", "мультфильм");
    private Movie item3 = new Movie(3, "3", "Отель Белград", "комедия");

    @BeforeEach
    public void setUp() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
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
        Movie[] returned = new Movie[]{item3};
        doReturn(returned).when(repository).findAll();

        manager.findById(idToFind);
        Movie[] expected = new Movie[]{item3};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindByIdIfNotExists() {
        int idToFind = 6;
        doNothing().when(repository).findById(idToFind);

        manager.findById(idToFind);
        Movie[] expected = new Movie[]{item3, item2, item1};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        doNothing().when(repository).removeById(idToRemove);

        Movie[] expected = new Movie[]{item2,item3};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{item1, item2, item3};
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{item1, item2,item3 };
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        doNothing().when(manager).findAll();
        manager.removeAll();
        assertArrayEquals(0, manager.removeAll());
//        @Test
//        public void whenAddCalledValueCaptured() {
//            MyList myList = mock(MyList.class);
//            ArgumentCaptor<String> valueCapture = ArgumentCaptor.forClass(String.class);
//            doNothing().when(myList).add(any(Integer.class), valueCapture.capture());
//            myList.add(0, "captured");
//
//            assertEquals("captured", valueCapture.getValue());
//        }

    }
    @Test
    public void shouldFindByID(){
        int idToFind = 2;
        Movie returned = item2;
        doReturn(returned).when(repository).findById(idToFind);

        manager.removeById(idToFind);
        Movie expected = item2;
        Movie actual = manager.findById(2);

        assertEquals(expected, actual);

    }
}
