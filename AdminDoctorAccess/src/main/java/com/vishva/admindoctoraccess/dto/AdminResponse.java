package com.vishva.admindoctoraccess.dto;

import com.vishva.admindoctoraccess.enums.Type;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdminResponse implements Serializable { //implemented serializable to avoid serialiazable error for get API
    private static final long serialVersionUID = 1L; // Required for serialization

    private Long id;
    private String name;
    private String email;
    private long phoneNumber;
    private String password;
    private Type type;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
