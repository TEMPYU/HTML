package LibraryManagementSystem;

public class Book {
    private String bookId;
    private String title;
    private String startDate;
    private String endDate;
    private boolean available;

    public Book(String bookId, String title, String startDate, String endDate , boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.available = isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
