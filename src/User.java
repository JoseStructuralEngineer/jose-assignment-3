

public class User {

    private String username;

    private String password;

    private String name;

    public User() {
    }
    public User(String[] userData) {
        this.username = userData[0];
        this.password = userData[1];
        this.name = userData[2];
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
