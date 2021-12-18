package de.htw.webtech.SafePass.web.api;

import java.util.List;

public class User {

    private long id;
    private String email;
    private String username;
    private String password;
    private String userRole;
    private List<Long> itemIds;

    public User(long id, String email, String username, String password, String userRole, List<Long> itemIds) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.itemIds = itemIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
