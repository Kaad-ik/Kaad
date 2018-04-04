package hu.elte.recipe.entities.httpentities;

public class UserHttpEntity {
    private String username;
    private String password;

    public UserHttpEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserHttpEntity() {
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
}
