package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    int afishaLength = 10;

    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieManager[] getAll() {
        MovieManager[] result = new MovieManager[items.length];
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}


//    Movie movie = new Movie();
//    Movie movie1 = new Movie(int afishaLength);