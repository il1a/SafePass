package de.htw.webtech.SafePass.web.api;

public class Item {

    private Long id;
    private String title;
    private String username;
    private String password;
    private String url;
    private String notes;
    private User holder;

    public Item(Long id, String title, String username, String password, String url, String notes, User holder) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.url = url;
        this.notes = notes;
        this.holder = holder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }
}