package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfficheItem;

import static org.junit.jupiter.api.Assertions.*;

class AfficheManagerTest {
    private final AfficheManager manager = new AfficheManager();
    private final AfficheItem first = new AfficheItem(1, 1, "Бладшот", "боевик", false);
    private final AfficheItem second = new AfficheItem(2, 2, "Вперёд", "мультфильм", false);
    private final AfficheItem third = new AfficheItem(3, 3, "Отель 'Белград'", "комедия", false);
    private final AfficheItem fourth = new AfficheItem(4, 4, "Джентльмены", "боевик", false);
    private final AfficheItem fifth = new AfficheItem(5, 5, "Человек-невидимка", "ужасы", false);
    private final AfficheItem sixth = new AfficheItem(6, 6, "Паразиты", "триллер", false);
    private final AfficheItem seventh = new AfficheItem(7, 7, "Пиноккио", "фэнтези", false);
    private final AfficheItem eighth = new AfficheItem(8, 8, "Услышь меня", "драма", false);
    private final AfficheItem ninth = new AfficheItem(9, 9, "Тролли.Мировой тур", "мультфильм", true);
    private final AfficheItem tenth = new AfficheItem(10, 10, "Номер один", "комедия", true);
    private final AfficheItem eleventh = new AfficheItem(11, 11, "Мой друг мистер Персиваль", "драма", true);
    private final AfficheItem twelfth = new AfficheItem(12, 12, "Афера в Майами", "триллер", true);
    private final AfficheItem thirteenth = new AfficheItem(13, 13, "Тайная жизнь", "драма", true);
    private final AfficheItem fourteenth = new AfficheItem(14, 14, "Тьма", "ужасы", true);
    private final AfficheItem fifteenth = new AfficheItem(15, 15, "Туннель: Опасно для жизни", "триллер", true);

    @Test
    public void shouldSetMoviesLength() {
        AfficheManager manager = new AfficheManager(15);

        assertEquals(15, manager.getMoviesLength());
    }
    @Test
    public void shouldShowIfAddedLess10Movies() {
        AfficheManager manager = new AfficheManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        AfficheItem[] actual = manager.getAll();
        AfficheItem[] expected = new AfficheItem[]{eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        manager.add(fourteenth);
        manager.add(fifteenth);
    }

    @Test
    public void shouldShow10LatestMovies() {
        AfficheItem[] actual = manager.getAll();
        AfficheItem[] expected = new AfficheItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLess10Movies() {
        manager.setMoviesLength(5);

        AfficheItem[] actual = manager.getAll();
        AfficheItem[] expected = new AfficheItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMore10Movies() {
        manager.setMoviesLength(15);

        AfficheItem[] actual = manager.getAll();
        AfficheItem[] expected = new AfficheItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }



}