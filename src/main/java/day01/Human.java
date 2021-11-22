package day01;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        NameValidator nv = new NameValidator();
        YearOfBirthValidator yobv = new YearOfBirthValidator();

        if (yobv.isValidYear(yearOfBirth) && nv.isValidName(name)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
