package test;

import main.ZpracovaniMoje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for ZpracovaniMoje class
 */
public class ZpracovaniMojeTest {

    /**
     * Tests for comp(int, int) method
     * */
    @Test
    public void compareIntegers(){

        //test a<b
        assertEquals(-1, ZpracovaniMoje.comp(5, 10), "5 should be less than 10");
        //test a>b
        assertEquals(1, ZpracovaniMoje.comp(10, 5), "10 should be greater than 5");
        //test a==b
        assertEquals(0, ZpracovaniMoje.comp(5, 5), "5 should be equal to 5");

        //negative numbers
        assertEquals(-1, ZpracovaniMoje.comp(-5, -4), "-5 should be less than -4");
        assertEquals(1, ZpracovaniMoje.comp(-4, -5), "-4 should be greater than -5");
        assertEquals(0, ZpracovaniMoje.comp(-4, -4), "-4 should be equal to -4");

        //negative/positive numbers + zeros
        assertEquals(-1, ZpracovaniMoje.comp(-5, 5), "-5 should be less than 10");
        assertEquals(1, ZpracovaniMoje.comp(4, -5), "4 should be greater than -5");
        assertEquals(0, ZpracovaniMoje.comp(0, 0), "0 should be equal to 0");

        //boundary values
        assertEquals(-1, ZpracovaniMoje.comp(Integer.MIN_VALUE, Integer.MAX_VALUE), "MIN_VALUE should be less than MAX_VALUE");
        assertEquals(1, ZpracovaniMoje.comp(Integer.MAX_VALUE, Integer.MIN_VALUE), "MAX_VALUE should be greater than MIN_VALUE");
        assertEquals(0, ZpracovaniMoje.comp(Integer.MAX_VALUE, Integer.MAX_VALUE), "MAX_VALUE should be equal to MAX_VALUE");
        assertEquals(0, ZpracovaniMoje.comp(Integer.MIN_VALUE, Integer.MIN_VALUE), "MIN_VALUE should be equal to MIN_VALUE");

    }

    /**
     * Tests for comp(String, String) method
     * */
    @Test
    public void compareStrings() {
        //test strings
        assertEquals(-1, ZpracovaniMoje.comp("apple", "banana"), "'apple' should be less than 'banana'");
        assertEquals(1, ZpracovaniMoje.comp("banana", "apple"), "'banana' should be greater than 'apple'");
        assertEquals(0, ZpracovaniMoje.comp("cherry", "cherry"), "'cherry' should be equal to 'cherry'");

        //test one-character strings
        assertEquals(-1, ZpracovaniMoje.comp("a", "b"), "'a' should be less than 'b'");
        assertEquals(1, ZpracovaniMoje.comp("b", "a"), "'b' should be greater than 'a'");
        assertEquals(0, ZpracovaniMoje.comp("a", "a"), "'abc' should be equal to 'abc'");

        //test empty strings
        assertEquals(-1, ZpracovaniMoje.comp("", "a"), "empty string should be less than 'a'");
        assertEquals(1, ZpracovaniMoje.comp("b", ""), "'b' should be greater than empty string");
        assertEquals(0, ZpracovaniMoje.comp("", ""), "two empty strings should be equal");
    }
}
