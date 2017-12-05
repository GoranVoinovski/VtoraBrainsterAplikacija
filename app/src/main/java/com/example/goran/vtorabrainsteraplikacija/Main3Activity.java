package com.example.goran.vtorabrainsteraplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {


    @BindView(R.id.name)
    EditText ime;
    @BindView(R.id.lastname)
    EditText prezime;
    @BindView(R.id.username)
    EditText korIme;
    @BindView(R.id.rbm)
    RadioButton male;
    @BindView(R.id.rbf)
    RadioButton female;

    ArrayList<Users> users;
    String name = "";
    String lastname = "";
    String username = "";
    char pol = 'M';
    User user;
    String kod = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.hasExtra("Login")) {
            kod = "Login";

        } else if (intent.hasExtra("Add")) {
            kod = "Add";
        }


        users = new ArrayList<Users>();

        Intent intentkorisnik = getIntent();
        if (intentkorisnik.hasExtra("Mail")) {

            String mail = intentkorisnik.getStringExtra("Mail");
            String pass = intentkorisnik.getStringExtra("Pass");

            user = new User(mail, pass, users);

        }
        Intent intentedit = getIntent();
        if (intentedit.hasExtra("Users")) {
            Users user;
            user = (Users) intentedit.getSerializableExtra("Users");
            ime.setText(user.getName());
            prezime.setText(user.getLastname());
            korIme.setText(user.getUsername());
            pol = user.getGender();
            if (pol == 'M') {

                male.setChecked(true);
            } else {
                female.setChecked(true);
            }


        }

        ime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ime.setHintTextColor(getResources().getColor(android.R.color.white));
                prezime.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
                korIme.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
            }
        });

        prezime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ime.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
                prezime.setHintTextColor(getResources().getColor(android.R.color.white));
                korIme.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
            }
        });

        korIme.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ime.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
                prezime.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
                korIme.setHintTextColor(getResources().getColor(android.R.color.white));
            }
        });
    }


    @OnClick(R.id.adddetail)
    public void Prati() {
        name = ime.getText().toString();
        lastname = prezime.getText().toString();
        username = korIme.getText().toString();
        if (male.isChecked()) {
            pol = 'M';
            male.setChecked(true);
        } else {
            pol = 'F';
            female.setChecked(true);
        }

        if (name.isEmpty() || lastname.isEmpty() || username.isEmpty()) {

            if (name.isEmpty()){ime.setError("Enter your name");
            }else if (lastname.isEmpty()){prezime.setError("Enter your lastname");
            }else{korIme.setError("Enter your username");}

        } else {


            if (kod.equals("Add")){
                Users user = new Users(name, lastname, username,pol);
                Intent intenuseri1 = new Intent();
                intenuseri1.putExtra("Add", user);

                setResult(RESULT_OK, intenuseri1);

                finish();

            }else if (kod.equals("Login")){
                Intent intenuseri = new Intent(Main3Activity.this, Main4Activity.class);
                users.add(new Users(name, lastname, username,pol));
                intenuseri.putExtra("Lista", (Serializable) users);
                startActivity(intenuseri);


            }else {

                Users user = new Users(name, lastname, username,pol);
                Intent intenuseri1 = new Intent();
                intenuseri1.putExtra("Edited", user);

                setResult(RESULT_OK, intenuseri1);

                finish();}

        }


        }


    }
