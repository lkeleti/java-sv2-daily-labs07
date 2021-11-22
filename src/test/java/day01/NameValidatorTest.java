package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameValidatorTest {

    NameValidator nameValidator = new NameValidator();

    @Test
    void isValidNameTest() {
        assertTrue(nameValidator.isValidName("John Doe"));
    }

    @Test
    void isValidNameWithNullTest() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                        ()-> nameValidator.isValidName(null)
                );
        assertEquals("Invalid name", iae.getMessage());
    }

    @Test
    void isValidNameWithWhiteSpacesTest() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                        ()-> nameValidator.isValidName("   ")
                );
        assertEquals("Invalid name", iae.getMessage());
    }

    @Test
    void isValidNameWithOneNameTest() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                        ()-> nameValidator.isValidName("John")
                );
        assertEquals("Invalid name", iae.getMessage());
    }
}