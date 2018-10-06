package com.example.a700gtk.recette20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityCreateAccount extends AppCompatActivity {

    private DatabaseReference fbData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        fbData = FirebaseDatabase.getInstance().getReference("Stuff");

    }

    public void submitButton(View view) {
        fbData.child("this").setValue("SOME STUFF");

    }
}
