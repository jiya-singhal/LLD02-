import java.util.*;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    //Total no. of books by an author
    public long countBooksByAuthor(String author) {
        return books.stream()
                    .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                    .count();
    }

    // All authors
    public Set<String> getAllAuthors() {
        Set<String> authors = new TreeSet<>();
        for (Book b : books) {
            authors.add(b.getAuthor());
        }
        return authors;
    }

    // Get all books by an author
    public List<String> getBooksByAuthor(String author) {
        List<String> titles = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                titles.add(b.getTitle());
            }
        }
        return titles;
    }

    // Get books by rating
    public List<Book> getBooksByRating(double rating) {
        List<Book> filtered = new ArrayList<>();
        double epsilon = 0.0001;

        for (Book b : books) {
            if (Math.abs(b.getRating() - rating) < epsilon) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    // Books & Prices by an author
    public Map<String, Integer> getBooksAndPricesByAuthor(String author) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                map.put(b.getTitle(), b.getPrice());
            }
        }
        return map;
    }
}
