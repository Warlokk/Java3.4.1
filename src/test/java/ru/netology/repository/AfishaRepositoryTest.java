package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    MovieItem first = new MovieItem(1, "Постер", "Бладшот", "Боевик");
    MovieItem second = new MovieItem(2, "Постер", "Вперёд", "Мультфильм");
    MovieItem third = new MovieItem(3, "Постер", "Отель Белград", "Комедия");
    MovieItem fourth = new MovieItem(4, "Постер", "Джентльмены", "Боевик");
    MovieItem fifth = new MovieItem(5, "Постер", "Человек-невидимка", "Ужасы");

    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldGetEmpty() {
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToEmpty() {
        repository.save(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToExisted() {
        repository.save(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
        repository.save(second);
        MovieItem[] expectedAdded = new MovieItem[]{first, second};
        MovieItem[] actualAdded = repository.findAll();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void shouldFindAll() {
        setUp();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        setUp();
        repository.removeAll();
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        setUp();
        int removeId = 3;
        repository.removeById(removeId);
        MovieItem[] expected = new MovieItem[]{first, second, fourth, fifth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByNonExistId() {
        setUp();
        int removeId = 3;
        repository.removeById(removeId);
        MovieItem[] expected = new MovieItem[]{first, second, fourth, fifth};
        MovieItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        setUp();
        int seekId = 3;
        MovieItem expected = third;
        MovieItem actual = repository.findById(seekId);
        assertEquals(expected, actual);
    }
}