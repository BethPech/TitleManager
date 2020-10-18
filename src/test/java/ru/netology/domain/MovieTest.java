package ru.netology.domain;

import org.junit.jupiter.api.Test;

public class MovieTest {
    @Test
    void shouldSetTheName() {
        Movie movie1 = new Movie("1", "1", "Бладшот", "Боевик");
        Movie movie2 = new Movie("2", "2", "Вперёд", "мультфильм");
        Movie movie3 = new Movie("3", "3", "Отель Белград", "комедия");
        Movie movie4 = new Movie("4", "4", "Джентльмены", "боевик");
        Movie movie5 = new Movie("5", "5", "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie("6", "6", "Тролли.Мировой тур", "мультфильм");
        Movie movie7 = new Movie("7", "7", "Номер один", "комедия");


    }
}
