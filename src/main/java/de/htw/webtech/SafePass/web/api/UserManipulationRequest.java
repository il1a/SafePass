package de.htw.webtech.SafePass.web.api;

public class UserManipulationRequest {

    private String email;
    private String username;
    private String password;
    private String userRole;

    public UserManipulationRequest(String email, String username, String password, String userRole) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}