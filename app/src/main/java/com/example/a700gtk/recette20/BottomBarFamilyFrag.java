package com.example.a700gtk.recette20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomBarFamilyFrag  extends Fragment {
   public static final String ARG_TITLE = "arg_title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_fam, null);
    }


    // public onPause(){}



}
