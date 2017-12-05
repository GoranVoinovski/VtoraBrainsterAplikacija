package com.example.goran.vtorabrainsteraplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.spiner)Spinner spin;
    @BindView(R.id.info)TextView informacii;

    ArrayList<Users> users = new ArrayList<>();
    ArrayAdapter<Users> adapter;
    Users users2;
    int kluc = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ButterKnife.bind(this);


        Intent intent1 = getIntent();
        if (intent1.hasExtra("Guest")) {

            Users user = new Users();
            users.add(user);

        }else {
            users = (ArrayList<Users>) intent1.getSerializableExtra("Lista");

        }

        adapter = new ArrayAdapter<Users>(this,android.R.layout.simple_list_item_1,users);
        adapter.notifyDataSetChanged();
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                users2 = adapter.getItem(position);
                informacii.setText("Name: " + users2.getName() + "\nLastname: " + users2.getLastname() + "\nGender: " + users2.getGender());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @OnClick(R.id.add)
    public void Add(View view){

        if (users2.username.equals("Guest")){

            Toast.makeText(this,"You cant add user on this account",Toast.LENGTH_LONG).show();
        }else {

            Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
            intent.putExtra("Add", "Add");
            startActivityForResult(intent, kluc);
        }

    }

    @OnClick(R.id.edit)
    public void Edit(View view){

        if (users2.username.equals("Guest")){

            Toast.makeText(this,"You cant edit this user",Toast.LENGTH_LONG).show();
        }else {

            Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
            intent.putExtra("Users", users2);
            startActivityForResult(intent, kluc);

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == kluc) {
            if (data.hasExtra("Add")) {
                users2 = (Users) data.getSerializableExtra("Add");
                users.add(users2);
                adapter.notifyDataSetChanged();
            }else if (data.hasExtra("Edited")){
                Users edituser = (Users) data.getSerializableExtra("Edited");
                users2.setName(edituser.getName());
                users2.setLastname(edituser.getLastname());
                users2.setUsername(edituser.getUsername());
                users2.setGender(edituser.getGender());
                adapter = new ArrayAdapter<Users>(this,android.R.layout.simple_list_item_1,users);
                spin.setAdapter(adapter);


            }


        }


    }
}
