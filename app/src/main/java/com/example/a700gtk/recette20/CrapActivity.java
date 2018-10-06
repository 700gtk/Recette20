package com.example.a700gtk.recette20;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class CrapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_crap_acticity);

        loadFrag(new BottomBarPublicFrag());

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bottomNav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadFrag(new BottomBarFamilyFrag());
                        return true;
                    case R.id.navigation_dashboard:
                        Toast.makeText(CrapActivity.this, "YOU MADE IT HERE", Toast.LENGTH_SHORT).show();
                        loadFrag(new BottomBarPublicFrag());
                        return true;
                    case R.id.navigation_notifications:
                        loadFrag(new BottomBarMakeRecetteFrag());
                        return true;
                }
                //return loadFrag(frag);
                return false;

            }
        });
    }

   // BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bottomNav);

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    //Fragment frag = null;
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    loadFrag(new BottomBarFamilyFrag());
//                    return true;
//                case R.id.navigation_dashboard:
//                    Toast.makeText(CrapActivity.this, "YOU MADE IT HERE", Toast.LENGTH_SHORT).show();
//                    loadFrag(new BottomBarPublicFrag());
//                    return true;
//                case R.id.navigation_notifications:
//                    loadFrag(new BottomBarMakeRecetteFrag());
//                   return true;
//            }
//            //return loadFrag(frag);
//            return false;
//        }
//    };

    private boolean loadFrag(Fragment frag) {

        if (frag != null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragContent, frag).commit();
            return true;
        }
        return false;
    }

}
