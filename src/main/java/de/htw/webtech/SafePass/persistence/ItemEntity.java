package de.htw.webtech.SafePass.persistence;

import javax.persistence.*;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "url")
    private String url;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "holder_id", referencedColumnName = "id")
    private UserEntity holder;

    public ItemEntity(String title, String username, String password, String url, String notes, UserEntity holder) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.url = url;
        this.notes = notes;
        this.holder = holder;
    }

    public ItemEntity() {
    }

    public Long getId() {
        return id;
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

    public UserEntity getHolder() {
        return holder;
    }

    public void setHolder(UserEntity holder) {
        this.holder = holder;
    }
}
