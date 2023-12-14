package LibraryManagementSystem;

public class User {
    private String userId;
    private String name;
    private boolean isNewUser;

    public User(String userId, String name, boolean isNewUser) {
        this.userId = userId;
        this.name = name;
        this.isNewUser = isNewUser;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

}
