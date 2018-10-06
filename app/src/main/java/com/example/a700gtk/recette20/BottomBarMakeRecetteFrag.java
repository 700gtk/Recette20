package com.example.a700gtk.recette20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class BottomBarMakeRecetteFrag extends Fragment {
    private int counter = 0;
    private Button SubmitRecipeButton;
    private DatabaseReference fbData;
    private Map<String, Object> toSend;

    private String title;
    private String ingredients;
    private String steps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.make_recette_frag, null);
        fbData = FirebaseDatabase.getInstance().getReference("Stuff");

        title = view.findViewById(R.id.titleOfNewRecipe).toString();
        ingredients = view.findViewById(R.id.ingredientsForNewRecipe).toString();
        steps = view.findViewById(R.id.stepsForNewRecipe).toString();

        SubmitRecipeButton = (Button) view.findViewById(R.id.SubmitNewRecipeButton);
        SubmitRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSend.put("Title", title);
                toSend.put("Ingredients", ingredients);
                toSend.put("Steps", steps);

                fbData.child("thisUser").setValue(toSend);
            }
        });


        return view;
    }


}
