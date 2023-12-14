package LibraryManagementSystem;

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
     static Scanner scanner = new Scanner(System.in);
     static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("----Welcome To LIBRARY----");

        User user1 = library.addUser("U001", "John Doe", false);
        User user2 = library.addUser("U002", "Jane Doe", false);
        User user3 = library.addUser("U003", "Alice Smith", false);

        Book book1 = library.addBook("B001", "Sample Book One", "01-01-2023", "31-02-2023" , true);
        Book book2 = library.addBook("B002", "Sample Book Two", "01-01-2023", "30-03-2023" , true);
        Book book3 = library.addBook("B003", "Sample Book Threee", "01-01-2023", "31-02-2023" , true);

        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBookAvailability();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewBookHistory();
                    break;
                case 5:
                    listAvailableBooks();
                    break;
                case 6:
                    viewUserDetails();
                    break;
                case 7:
                    listAllUsers();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        }
        System.out.println("Thank you");
    }
    private static void printMenu() {
        System.out.println("\nChoose One Option :");
        System.out.println("1. Check Book Availability : ");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. View Book History");
        System.out.println("5. List Available Books");
        System.out.println("6. View User Details");
        System.out.println("7. List All Users");
        System.out.println("8. Exit");
    }
    private static void listAllUsers() {
        List<User> allUsers = library.getAllUsers();
        if (!allUsers.isEmpty()) {
            System.out.println("All users:");
            for (User user : allUsers) {
                System.out.println(user.getName());
            }
        } else {
            System.out.println("No users in the system.");
        }
    }
    private static void viewUserDetails() {
        System.out.print("Enter your user ID: ");
        String userId = scanner.next();
        User user = library.getUserDetails(userId);
        if (user != null) {
            System.out.println("User details:");
            System.out.println(user.getName());
        } else {
            System.out.println("User not found.");
        }
    }
    private static void listAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        if (!availableBooks.isEmpty()) {
            System.out.println("Available books:");
            for (Book book : availableBooks) {
                System.out.println("---------------");
                System.out.println("Book ID : " + book.getBookId());
                System.out.println("Book Title : " + book.getTitle());
                System.out.println("---------------");
            }
        } else {
            System.out.println("No available books.");
        }
    }
    private static void viewBookHistory() {
        return;
    }
    private static void returnBook() {
        System.out.print("Enter your user ID: ");
        String userId = scanner.next();

        System.out.print("Enter the book ID: ");
        String bookId = scanner.next();

        library.returnBook(userId, bookId);
    }
    private static void borrowBook() {
        System.out.print("Enter your user ID: ");
        String userId = scanner.next();

        User user = library.getUserDetails(userId);

        if (user != null) {
            handleBorrowBook(user);
        } else {
            System.out.println("Not a Existing user . Please provide your details to register:");
            System.out.print("Enter your name: ");
            String name = scanner.next();
            User newUser = library.addUser(userId, name, true);
            handleBorrowBook(newUser);
        }
    }
    private static void handleBorrowBook(User user) {
        System.out.print("Enter the book ID: ");
        String bookId = scanner.next();
        Book book = library.getBookDetails(bookId);
        if (book != null) {
            if (book.isAvailable()) {
                library.borrowBook(user.getUserId(), book.getBookId());
            } else {
                System.out.println("Book is currently borrowed. Cannot borrow.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }
    private static void checkBookAvailability() {
        System.out.print("Enter the book ID: ");
        String bookId = scanner.next();
        Book book = library.getBookDetails(bookId);
        if (book != null) {
            if (book.isAvailable()) {
                System.out.println("Book is available for borrowing.");
            } else {
                System.out.println("Book is currently borrowed.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

}
