package com.example.goran.vtorabrainsteraplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


    }

    @OnClick(R.id.login)
    public void KlikLogin (View view){

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);


    }

    @OnClick (R.id.guest)
    public void KlikGuest(View view){

        Users gostin = new Users();
        Intent intentguest = new Intent(MainActivity.this, Main4Activity.class);
        intentguest.putExtra("Guest", gostin);
        startActivity(intentguest);


    }

}
