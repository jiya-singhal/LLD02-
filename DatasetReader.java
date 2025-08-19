import java.io.*;
import java.util.*;

public class DatasetReader {
    private List<Book> books;

    public DatasetReader(String filePath) throws IOException {
        books = new ArrayList<>();
        loadFromCSV(filePath);
    }

    private void loadFromCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); 

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            if (parts.length >= 7) {
                String title = parts[0].replace("\"", "");
                String author = parts[1].replace("\"", "");
                double rating = Double.parseDouble(parts[2]);
                int reviews = Integer.parseInt(parts[3]);
                int price = Integer.parseInt(parts[4]);
                int year = Integer.parseInt(parts[5]);
                String genre = parts[6].replace("\"", "");

                books.add(new Book(title, author, rating, reviews, price, year, genre));
            }
        }
        br.close();
    }

    public List<Book> getBooks() {
        return books;
    }
}
