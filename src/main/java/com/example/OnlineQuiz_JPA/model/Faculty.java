package com.example.OnlineQuiz_JPA.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;



    public Faculty(String uid, String username, String email, String photoUrl) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
    }

    public Faculty() {}


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


}
