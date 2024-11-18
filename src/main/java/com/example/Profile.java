package com.example;

public class Profile {
    final int id;
    final String firstName;
    final String lastName;
    final int age;

    public Profile(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String fGetFirstName () {
        return firstName;
    }
}