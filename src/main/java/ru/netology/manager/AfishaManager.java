package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaManager {
    private AfishaRepository repository;
    private int feedCount = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(int feedCount) {
        this.feedCount = feedCount;
    }

    public void add(MovieItem item) {
        repository.save(item);
    }

    public MovieItem[] getMoviesForFeed() {
        MovieItem[] items = repository.findAll();
        if (this.feedCount > items.length)
            feedCount = items.length;
        MovieItem[] result = new MovieItem[feedCount];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieItem[] getAll() {
        MovieItem[] items = repository.findAll();
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public MovieItem findById(int id) {
        MovieItem movie = repository.findById(id);
        return movie;
    }

    public void removeAll() {
        repository.removeAll();
    }

}
