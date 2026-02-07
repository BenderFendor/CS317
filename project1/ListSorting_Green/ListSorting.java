import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ListSorting {

  public static void main(String[] args) {
    List<String> listStrings = Arrays.asList("Orange", "Grape", "Apple", "Lemon", "Banana");
    System.out.println("Before sorting: " + listStrings);
    Collections.sort(listStrings);
    System.out.println("After sorting: " + listStrings);

    List<Character> listCharacters = Arrays.asList('F', 'C', 'A', 'B', 'Z', 'E', 'K', 'P');
    System.out.println("Before sorting: " + listCharacters);
    Collections.sort(listCharacters);
    System.out.println("After sorting: " + listCharacters);

    List<Integer> listIntegers = Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5);
    System.out.println("Before sorting: " + listIntegers);
    Collections.sort(listIntegers);
    System.out.println("After sorting: " + listIntegers);

    List<Date> listDates = new ArrayList<Date>();
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      listDates.add(dateFormatter.parse("2013-09-30"));
      listDates.add(dateFormatter.parse("2013-07-06"));
      listDates.add(dateFormatter.parse("2013-11-28"));
    } catch (ParseException ex) {
      System.err.print(ex);
    }
    System.out.println("Before sorting: " + listDates);
    Collections.sort(listDates);
    System.out.println("After sorting: " + listDates);

    List<Integer> listForReverse = new ArrayList<Integer>(Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5));
    System.out.println("Before sorting: " + listForReverse);
    Collections.sort(listForReverse);
    System.out.println("After sorting: " + listForReverse);
    Collections.reverse(listForReverse);
    System.out.println("After reversing: " + listForReverse);

    List<Movie> listMovies = new ArrayList<Movie>();
    listMovies.add(new Movie("Django Unchained", 8.5));
    listMovies.add(new Movie("Iron Man 1", 7.9));
    listMovies.add(new Movie("Motorcycle Diaries", 7.7));
    listMovies.add(new Movie("Lady Snowblood", 7.6));
    listMovies.add(new Movie("The Minecraft Movie", 5.5));
    listMovies.add(new Movie("Saving Private Ryan", 8.6));
    listMovies.add(new Movie("The Matrix", 8.7));
    listMovies.add(new Movie("Pulp Fiction", 3.0));
    System.out.println("Before sorting: " + listMovies);
    Collections.sort(listMovies);
    System.out.println("After sorting: " + listMovies);

    List<Movie> listMovies2 = new ArrayList<Movie>();
    listMovies2.add(new Movie("Django Unchained", 8.5));
    listMovies2.add(new Movie("Iron Man 1", 7.9));
    listMovies2.add(new Movie("Motorcycle Diaries", 7.7));
    listMovies2.add(new Movie("Lady Snowblood", 7.6));
    listMovies2.add(new Movie("The Minecraft Movie", 5.5));
    listMovies2.add(new Movie("Saving Private Ryan", 8.6));
    listMovies2.add(new Movie("The Matrix", 8.7));
    listMovies2.add(new Movie("Pulp Fiction", 3.0));
    System.out.println("Before sorting: " + listMovies2);
    Collections.sort(listMovies2, new MovieTitleComparator());
    System.out.println("After sorting: " + listMovies2);
  }

  static class Movie implements Comparable<Movie> {
    private String title;
    private double rating;

    public Movie(String title, double rating) {
      this.title = title;
      this.rating = rating;
    }

    public String getTitle() {
      return title;
    }

    public double getRating() {
      return rating;
    }

    public int compareTo(Movie movie) {
      double diff = movie.rating - this.rating;
      if (diff > 0) {
        return 1;
      } else if (diff < 0) {
        return -1;
      } else {
        return 0;
      }
    }

    public String toString() {
      return String.format("(%s, %.1f)", title, rating);
    }
  }

  static class MovieTitleComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
      return m1.getTitle().compareTo(m2.getTitle());
    }
  }
}
