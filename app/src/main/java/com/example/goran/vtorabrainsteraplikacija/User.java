package com.example.goran.vtorabrainsteraplikacija;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by goran on 5.12.17.
 */

public class User implements Serializable {

    String mail;
    String pass;
    ArrayList<Users> users;


    public User(String mail, String pass, ArrayList<Users> users) {
        this.mail = mail;
        this.pass = pass;
        this.users = users;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
}
