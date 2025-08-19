public class Book {
    private String title;
    private String author;
    private double rating;
    private int reviews;
    private int price;
    private int year;
    private String genre;

    public Book(String title, String author, double rating, int reviews, int price, int year, String genre) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }

    public int getReviews() {
        return reviews;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " by " + author + " | Rating: " + rating + " | Price: $" + price;
    }
}
