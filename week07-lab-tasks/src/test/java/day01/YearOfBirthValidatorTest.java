package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearOfBirthValidatorTest {
    YearOfBirthValidator yearOfBirthValidator = new YearOfBirthValidator();

    @Test
    void YearOfBirthValidatorTest() {
        assertTrue(yearOfBirthValidator.isValidYear(1901));
    }

    @Test
    void YearOfBirthValidatorInvalidTest() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                        ()->yearOfBirthValidator.isValidYear(1900)
                );
        assertEquals("Too old!", iae.getMessage());
    }
}