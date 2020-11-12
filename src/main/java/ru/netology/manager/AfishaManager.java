package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepositiry;

public class AfishaManager {
    private AfishaRepositiry repository;

    public AfishaManager(AfishaRepositiry repository) {
        this.repository = repository;
    }


    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getAll() {
        Movie[] items = repository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void findAll() {
        repository.findAll();
    }

    public Movie findById(int id) {
        Movie result = repository.findById(id);
        return result;
    }

}
