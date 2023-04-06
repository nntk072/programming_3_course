
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieAnalytics2 {

    private final List<Movie> movies;

    public MovieAnalytics2() {
        this.movies = new ArrayList<>();
    }

    public void populateWithData(String filename) throws FileNotFoundException, IOException {
        try (var br = new BufferedReader(new FileReader(filename))) {
            br.lines().map(line -> line.split(";"))
                    .map(parts -> new Movie(
                    parts[0],
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    parts[3],
                    Double.parseDouble(parts[4]),
                    parts[5]))
                    .forEach(movies::add);
            br.close();
        }
    }

    public void printCountByDirector(int n) {
        Map<String, Long> countByDirector = movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));
        countByDirector.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " movies"));
    }

    public void printAverageDurationByGenre() {
        Map<String, Double> averageDurationByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenrge, Collectors.averagingDouble(Movie::getDuration)));

        averageDurationByGenre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }

    void printAverageScoreByGenre() {
        Map<String, Double> averageDurationByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenrge, Collectors.averagingDouble(Movie::getScore)));

        averageDurationByGenre.entrySet().stream()
                .sorted(Map.Entry.<String,Double>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }
}
