package com.example.booting;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // ✅ This tells JPA to treat this class as a database entity
@Table(name = "users")
public class User {

    @Id  // ✅ This tells JPA which field is the primary key
    private int id;
    private String name;
    private String email;


    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
        // Default constructor needed for JSON deserialization
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }
}
