
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MovieAnalytics {

    private final List<Movie> movies;

    public MovieAnalytics() {
        this.movies = new ArrayList<>();
    }

    public static Consumer<Movie> showInfo() {
        return movie -> System.out.println(movie.getTitle() + " (By " + movie.getDirector() + ", " + movie.getReleaseYear() + ")");

    }

    public void populateWithData(String filename) throws FileNotFoundException, IOException {
        try (var br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0];
                int releaseYear = Integer.parseInt(parts[1]);
                int duration = Integer.parseInt(parts[2]);
                String genre = parts[3];
                double score = Double.parseDouble(parts[4]);
                String director = parts[5];
                Movie movie = new Movie(title, releaseYear, duration, genre, score, director);
                movies.add(movie);
            }
            br.close();
        }
    }

    public Stream<Movie> moviesAfter(int year) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= year)
                .sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBefore(int year) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() <= year)
                .sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= yearA && movie.getReleaseYear() <= yearB)
                .sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesByDirector(String director) {
        return movies.stream()
                .filter(movie -> movie.getDirector().equals(director))
                .sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

}
