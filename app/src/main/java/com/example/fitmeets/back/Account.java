package com.example.fitmeets.back;


import java.util.ArrayList;

/**
 * class Account
 */
public class Account {

    private final String username;
    private final String password;
    private final String email;
    private final Integer studentId;
    private final String major;
    private final ArrayList<String> interests;

    public Account(String username, String password, String email, Integer studentId, String major, ArrayList<String> interests) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.studentId = studentId;
        this.major = major;
        this.interests = interests;
    }

    public String getMajor() {return major;}

    public ArrayList<String> getInterests() {return interests;}

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getEmail() {return email;}

    public Integer getStudentId() {return studentId;}
}
