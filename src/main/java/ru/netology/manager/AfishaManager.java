package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaManager {
    private MovieItem[] items = new MovieItem[0];
    private int feedCount = 10;

    public AfishaManager(int feedCount) {
            this.feedCount = feedCount;
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getMoviesForFeed() {
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
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
