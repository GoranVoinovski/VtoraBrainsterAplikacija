package com.example.goran.vtorabrainsteraplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.email)EditText mail;
    @BindView(R.id.pass)EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

       mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               mail.setHintTextColor(getResources().getColor(android.R.color.white));
               pass.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
           }
       });

        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                pass.setHintTextColor(getResources().getColor(android.R.color.white));
                mail.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
            }
        });


    }

    @OnClick(R.id.login)
    public void KlikLogin(View view){

        String mailuser = mail.getText().toString();
        String passuser = pass.getText().toString();
        if (mailuser.isEmpty() || passuser.isEmpty()){
         if (mailuser.isEmpty()){mail.setError("Enter your mail");}else {pass.setError("Enter your password");}


        }else {
        Intent intentuser = new Intent(Main2Activity.this, Main3Activity.class);
        intentuser.putExtra("Mail",mailuser);
        intentuser.putExtra("Pass",passuser);
        intentuser.putExtra("Login", "Login");
        startActivity(intentuser);}




    }
}
