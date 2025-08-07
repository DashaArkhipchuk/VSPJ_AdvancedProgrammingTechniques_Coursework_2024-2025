package tests;

import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    void testAddNewEntry() {
        Map<String, Integer> dict = new HashMap<>();
        dict.put("key1", 100);
        assertTrue(dict.containsKey("key1"));
        assertEquals(100, dict.get("key1"));
    }

    @Test
    void testOverwriteValue() {
        Map<String, Integer> dict = new HashMap<>();
        dict.put("key", 5);
        dict.put("key", 10);
        assertEquals(10, dict.get("key"));
    }

    @Test
    void testMultipleEntries() {
        Map<String, String> dict = new HashMap<>();
        dict.put("a", "apple");
        dict.put("b", "banana");

        assertEquals("apple", dict.get("a"));
        assertEquals("banana", dict.get("b"));
        assertFalse(dict.containsKey("c"));
    }

    @Test
    void testNullKeyAndValue() {
        Map<String, String> dict = new HashMap<>();
        dict.put(null, "nullValue");
        dict.put("nullKey", null);

        assertEquals("nullValue", dict.get(null));
        assertNull(dict.get("nullKey"));
    }
}
