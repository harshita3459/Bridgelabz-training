package smart_university_library;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if(books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId) {
        for(Book book : books) {
            if(book.getBookId() == bookId && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(int bookId) {
        for(Book book : books) {
            if(book.getBookId() == bookId && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid book ID or book not issued.");
    }
}
