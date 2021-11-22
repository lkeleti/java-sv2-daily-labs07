package day01;

import java.time.LocalDate;

public class YearOfBirthValidator {

    public boolean isValidYear(int yearOfBirth) {
        if (yearOfBirth < LocalDate.now().getYear()-120) {
            throw new IllegalArgumentException("Too old!");
        }
        return true;
    }
}
