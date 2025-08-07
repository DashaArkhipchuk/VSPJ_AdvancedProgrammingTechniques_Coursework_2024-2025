package tests;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListIndexTest {

    @Test
    void testExistingItems() {
        List<String> list = List.of("apple", "banana", "pear");

        assertEquals(0, list.indexOf("apple"));
        assertEquals(1, list.indexOf("banana"));
        assertEquals(2, list.indexOf("pear"));
    }

    @Test
    void testNonExistingItem() {
        List<String> list = List.of("apple", "banana");

        assertEquals(-1, list.indexOf("mango"));
    }

    @Test
    void testEmptyList() {
        List<String> list = List.of();

        assertEquals(-1, list.indexOf("anything"));
    }

    @Test
    void testDuplicates() {
        List<String> list = List.of("a", "b", "a", "c");

        assertEquals(0, list.indexOf("a")); // First occurrence
    }
}