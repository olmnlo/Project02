package poolingSystem;

public class User {
    private String username;
    private String password;
    private String id;
    private boolean subs;

    public User(String username, String password, String id, boolean subs) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.subs = subs;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSubs() {
        return subs;
    }

    public void setSubs(boolean subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", subs=" + subs +
                '}';
    }
}
