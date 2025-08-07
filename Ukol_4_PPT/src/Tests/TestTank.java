import Main.Tank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Tank class.
 * Validates correct handling of overfilling, emptying, and status checks.
 */
public class TestTank {

    @Test
    void testInitialization() {
        Tank tank = new Tank(100);
        assertEquals(100, tank.getCapacity());
        assertEquals(0, tank.getCurrentVolume());
    }

    @Test
    void testAdd() {
        Tank tank = new Tank(100);
        tank.add(50);
        assertEquals(50, tank.getCurrentVolume());

        // Overflow test
        tank.add(60);
        assertEquals(100, tank.getCurrentVolume());
    }

    @Test
    void testRemove() {
        Tank tank = new Tank(100);
        tank.add(80);
        tank.remove(30);
        assertEquals(50, tank.getCurrentVolume());

        // Underflow test
        tank.remove(60);
        assertEquals(0, tank.getCurrentVolume());
    }

    @Test
    void testIsEmptyAndIsFull() {
        Tank tank = new Tank(100);
        assertTrue(tank.isEmpty());
        tank.add(100);
        assertTrue(tank.isFull());
    }
}