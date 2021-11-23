package day02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            fillListWithMovies(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!",ioe);
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    private void fillListWithMovies(List<String> lines) {
        for (String line: lines){
            String[] datas = line.split(";");
            addMovie(new Movie(datas[0],Integer.parseInt(datas[1]),datas[2]));
        }
    }
}
