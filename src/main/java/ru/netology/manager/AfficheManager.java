package ru.netology.manager;

import ru.netology.domain.AfficheItem;

public class AfficheManager {
    private int moviesLength = 10;
    private AfficheItem[] items = new AfficheItem[0];

    public AfficheManager() {
    }

    public AfficheManager(int moviesLength) {
        this.moviesLength = moviesLength;
    }

    public void setMoviesLength(int moviesLength) {
        this.moviesLength = moviesLength;
    }

    public int getMoviesLength() {
        return moviesLength;
    }

    public void add(AfficheItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        AfficheItem[] tmp = new AfficheItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfficheItem[] getAll() {
        int length = Math.min(items.length, moviesLength);
        AfficheItem[] result = new AfficheItem[length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
