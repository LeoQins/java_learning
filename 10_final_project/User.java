// User.java - 代表用户的实体类 (Model)
public class User {
    private static int idCounter = 1;
    private int id;
    private String username;
    private String password; // 在真实项目中，密码应该是加密存储的

    public User(String username, String password) {
        this.id = idCounter++;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
