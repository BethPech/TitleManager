package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int afishaLength = 10;

    public MovieManager() {
    }


    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[Math.min(afishaLength, items.length)];
        for (int i = 0; i < Math.min(afishaLength, items.length); i++) {
            int index = Math.min(afishaLength, items.length) - i - 1;
            result[i] = items[index];
        }
        return result;
    }



    public MovieManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public Movie[] getAllLastItems() {
        Movie[] result = new Movie[];
        for (int i = 0; i < Math.min(afishaLength, items.length); i++) {
            int index = Math.min(afishaLength, items.length) - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
