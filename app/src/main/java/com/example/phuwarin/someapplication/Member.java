package com.example.phuwarin.someapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Phuwarin on 3/8/2017.
 */

public class Member {
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;
    @SerializedName("email")    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
