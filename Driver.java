import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DatasetReader reader = new DatasetReader("bestsellers with categories.csv");
            BookService service = new BookService(reader.getBooks());

            while (true) {
                System.out.println("\n=== Amazon Bestsellers Menu ===");
                System.out.println("1. Total number of books by an author");
                System.out.println("2. List all authors");
                System.out.println("3. List all books by an author");
                System.out.println("4. Find books with a given user rating");
                System.out.println("5. Prices of all books by an author");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter author name: ");
                        String a1 = sc.nextLine();
                        System.out.println("Total books: " + service.countBooksByAuthor(a1));
                        break;

                    case 2:
                        System.out.println("Authors:");
                        for (String auth : service.getAllAuthors()) {
                            System.out.println(auth);
                        }
                        break;

                    case 3:
                        System.out.print("Enter author name: ");
                        String a2 = sc.nextLine();
                        List<String> titles = service.getBooksByAuthor(a2);
                        if (titles.isEmpty()) {
                            System.out.println("No books found for " + a2);
                        } else {
                            System.out.println("Books by " + a2 + ":");
                            titles.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.print("Enter rating: ");
                        double r = sc.nextDouble();
                        List<Book> rated = service.getBooksByRating(r);
                        if (rated.isEmpty()) {
                            System.out.println("No books found with rating " + r);
                        } else {
                            rated.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.print("Enter author name: ");
                        String a3 = sc.nextLine();
                        Map<String, Integer> prices = service.getBooksAndPricesByAuthor(a3);
                        if (prices.isEmpty()) {
                            System.out.println("No books found for " + a3);
                        } else {
                            prices.forEach((title, price) -> 
                                System.out.println(title + " : $" + price));
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
