
public class Movie {
    private final String title;
    private final int releaseYear;
    private final int duration;
    private final String genrge;
    private final double score;
    private final String director;
    public Movie(String title, int releaseYear, int duration, String genre, double score, String director) {
        //Get string variable by name
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genrge = genre;
        this.score = score;
        this.director = director;
        
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenrge() {
        return genrge;
    }

    public double getScore() {
        return score;
    }

    public String getDirector() {
        return director;
    }

}
