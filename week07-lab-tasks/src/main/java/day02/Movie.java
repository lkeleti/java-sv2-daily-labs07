package day02;

public class Movie {
    private String title;
    private int releaseYear;
    private String director;

    public Movie(String name, int releaseYear, String director) {
        this.title = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }
}
