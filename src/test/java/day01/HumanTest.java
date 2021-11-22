package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testConstructor() {
        IllegalArgumentException iae = assertThrows(
                IllegalArgumentException.class,
                ()-> new Human("John Doe", 1899)
        );
        assertEquals("Too old!", iae.getMessage());

        iae = assertThrows(
                IllegalArgumentException.class,
                ()-> new Human(null, 1975)
        );
        assertEquals("Invalid name!", iae.getMessage());

        iae = assertThrows(
                IllegalArgumentException.class,
                ()-> new Human("  ", 1975)
        );
        assertEquals("Invalid name!", iae.getMessage());

        iae = assertThrows(
                IllegalArgumentException.class,
                ()-> new Human("John", 1975)
        );
        assertEquals("Invalid name!", iae.getMessage());
    }

    @Test
    void getName() {
        Human human = new Human("John Doe", 1975);
        assertEquals("John Doe", human.getName());
    }

    @Test
    void getYearOfBirth() {
        Human human = new Human("John Doe", 1975);
        assertEquals(1975, human.getYearOfBirth());
    }
}