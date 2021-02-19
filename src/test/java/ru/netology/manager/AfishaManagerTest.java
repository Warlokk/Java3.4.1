package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    MovieItem first = new MovieItem(1, "Постер", "Бладшот", "Боевик");
    MovieItem second = new MovieItem(2, "Постер", "Вперёд", "Мультфильм");
    MovieItem third = new MovieItem(3, "Постер", "Отель Белград", "Комедия");
    MovieItem fourth = new MovieItem(4, "Постер", "Джентльмены", "Боевик");
    MovieItem fifth = new MovieItem(5, "Постер", "Человек-невидимка", "Ужасы");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldGetEmpty() {
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToEmpty() {
        manager.add(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToExisted() {
        manager.add(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        manager.add(second);
        MovieItem[] expectedAdded = new MovieItem[]{second, first};
        MovieItem[] actualAdded = manager.getAll();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void shouldGetMoviesForFeed() {
        setUp();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFlexFeed() {
        manager = new AfishaManager(3);
        setUp();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }
}