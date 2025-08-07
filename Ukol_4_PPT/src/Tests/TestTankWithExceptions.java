import Main.TankWithExceptions;
import Exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTankWithExceptions {

    private TankWithExceptions tank;

    @BeforeEach
    void setUp() {
        tank = new TankWithExceptions(100);
    }

    @Test
    void testInitialValues() {
        assertEquals(100, tank.getCapacity());
        assertEquals(0, tank.getCurrentVolume());
        assertTrue(tank.isEmpty());
        assertFalse(tank.isFull());
    }

    @Test
    void testAddNormal() throws FullTankException {
        tank.add(50);
        assertEquals(50, tank.getCurrentVolume());
    }

    @Test
    void testRemoveNormal() throws FullTankException, EmptyTankException {
        tank.add(70);
        tank.remove(30);
        assertEquals(40, tank.getCurrentVolume());
    }

    @Test
    void testAddExactToFull() throws FullTankException {
        tank.add(100);
        assertTrue(tank.isFull());
        assertEquals(100, tank.getCurrentVolume());
    }

    @Test
    void testRemoveToEmpty() throws FullTankException, EmptyTankException {
        tank.add(40);
        tank.remove(40);
        assertTrue(tank.isEmpty());
        assertEquals(0, tank.getCurrentVolume());
    }

    @Test
    void testAddOverflowThrowsException() throws FullTankException {
        tank.add(90);
        FullTankException ex = assertThrows(FullTankException.class, () -> tank.add(20));
        assertEquals("Tank is full!", ex.getMessage());
    }

    @Test
    void testRemoveUnderflowThrowsException() throws FullTankException {
        tank.add(10);
        EmptyTankException ex = assertThrows(EmptyTankException.class, () -> tank.remove(20));
        assertEquals("Tank is empty!", ex.getMessage());
    }

    @Test
    void testMultipleValidOperations() throws FullTankException, EmptyTankException {
        tank.add(30);
        tank.remove(10);
        tank.add(50);
        tank.remove(20);

        assertEquals(50, tank.getCurrentVolume());
        assertFalse(tank.isEmpty());
        assertFalse(tank.isFull());
    }

    @Test
    void testIsFullAfterOverflowAttempt() {
        try {
            tank.add(100);
            tank.add(1);
            fail("Expected FullTankException was not thrown");
        } catch (FullTankException e) {
            assertEquals("Tank is full!", e.getMessage());
        }
    }

    @Test
    void testIsEmptyAfterUnderflowAttempt() {
        try {
            tank.remove(1);
            fail("Expected EmptyTankException was not thrown");
        } catch (EmptyTankException e) {
            assertEquals("Tank is empty!", e.getMessage());
        }
    }
}