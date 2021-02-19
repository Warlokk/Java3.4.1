package ru.netology.manager;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager;
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
    void shouldGetMoviesForFeed() {
        setUp();
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetMoviesForFlexFeed() {
        setUp();
        manager.setFeedCount(3);
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] expected = new MovieItem[]{fifth, fourth, third};
        MovieItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }


}