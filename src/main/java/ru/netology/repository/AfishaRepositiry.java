package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepositiry {
    private Movie[] items = new Movie[0];
    Movie[] items1 = new Movie[9];
        {
                Movie item1 = new Movie(1, "1", "Бладшот", "Боевик");
        Movie item2 = new Movie(2, "2", "Вперёд", "мультфильм");
        Movie item3 = new Movie(3, "3", "Отель Белград", "комедия");
        Movie item4 = new Movie(4, "4", "Джентльмены", "боевик");
        Movie item5 = new Movie(5, "5", "Человек-невидимка", "ужасы");
        Movie item6 = new Movie(6, "6", "Тролли.Мировой тур", "мультфильм");
        Movie item7 = new Movie(7, "7", "Номер один", "комедия");
        Movie item8 = new Movie(8, "8", "Номер один", "комедия");
        Movie item9 = new Movie(9, "9", "Номер один", "комедия");
    }


    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
            }




    public Movie[]  findById(int id) {
        int length = 1;
        Movie[] tmp = new Movie[length];
        for (Movie items1 : this.items1) {
            if (items1.getId() == id) {
                return tmp;
            }
        }
        return null;
    }

    public Movie[] removeById(int id) {
        int length = items1.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items1) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items1 = tmp;
        return tmp;
    }

    public Movie[] removeAll() {
        return items;
    }
}
