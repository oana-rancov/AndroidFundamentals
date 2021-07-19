package com.example.androidfundamentals.week8;

import com.google.gson.annotations.SerializedName;

public class Child {
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;

    public String getName() { return firstname; }

    public void setName(String name) { this.firstname = name; }

    public String getSurname() { return lastname; }

    public void setSurname(String surname) { this.lastname = surname; }

    @Override
    public String toString(){
        return "Person{" +
                "name='" + firstname + '\'' +
                ", surname='" + lastname + '\'' +
                '}';
    }

}
