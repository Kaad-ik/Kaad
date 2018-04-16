package hu.elte.recipe.entities.httpentities;

public class UserHttpEntity {
    private String userName;
    private String password;

    public UserHttpEntity(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public UserHttpEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
