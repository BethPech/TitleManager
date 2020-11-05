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

    public Movie[] removeById(int id) {
        Movie[] result = repository.removeById(id);
        return result;
    }

    public Movie[] removeAll(Movie[] id) {
        repository.removeAll();
        return id;
    }

    public void findAll() {
        repository.findAll();
    }

    public Movie findById(int id) {
        Movie result = repository.findById(id);
        return result;
    }

}
