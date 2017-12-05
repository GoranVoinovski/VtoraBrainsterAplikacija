package com.example.goran.vtorabrainsteraplikacija;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by goran on 5.12.17.
 */

public class Users implements Serializable {


    String name;
    String lastname;
    String username;
    char gender;


    public Users() {

        name = "";
        lastname = "";
        username = "Guest";
        gender = 'M';
    }

    public Users(String name, String lastname, String username, char gender) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {


        return username;
    }

}
