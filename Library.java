package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    public User getUserDetails(String userId) {
        return findUser(userId);
    }

    public List<User> getAllUsers() {
        return users;
    }
    public Book addBook(String bookId , String title , String startDate , String endDate , boolean isAvailable){
        Book book = new Book(bookId , title , startDate , endDate , isAvailable);
        books.add(book);
        return book;
    }
    public User addUser(String userId, String name, boolean isNewUser) {
        User user = new User(userId, name, isNewUser);
        users.add(user);
        return user;
    }

    public Book getBookDetails(String bookId) {
        return findBook(bookId);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void borrowBook(String userId, String bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user != null && book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available or user not found.");
        }
    }

    public void returnBook(String userId, String bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user != null && book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not borrowed by the user or book not found.");
        }
    }


    private User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

}
