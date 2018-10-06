package com.example.a700gtk.recette20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpPage extends AppCompatActivity {//implements View.OnClickListener {

    private Button createAcct;
    private Button signIn;
    private Button facebookLogin;
    private EditText emailString;
    private EditText pswdString;

    private ProgressDialog pd;
    private FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        fbAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);

        createAcct = (Button) findViewById(R.id.CreateAcct);
        signIn = (Button) findViewById(R.id.SignIn);

        emailString = (EditText) findViewById(R.id.EmailString);
        pswdString = (EditText) findViewById(R.id.PswdString);



       // createAcct.setOnClickListener(this);
        //signIn.setOnClickListener(this);
    }

    private void homePage(){

    }

//    @Override
//    public void onClick(View view) {
//        if(view == createAcct){
//           //Uncomment this when in actual production so to register the user
//            // registerUser();
//            Intent i = new Intent(SignUpPage.this, homePage.class);
//            startActivity(i);
//        }
//        if(view == signIn) {
//            Toast.makeText(this, "MADE THIS ONE", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(SignUpPage.this, homePage.class);
//            startActivity(i);
//        }
//    }

    private void registerUser() {
        String email = emailString.getText().toString().trim();
        String pswd = pswdString.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pswd)){
            Toast.makeText(this, "Can't leave spaces blank.", Toast.LENGTH_SHORT).show();
        return;
        }

        if(!email.contains("@")){
            Toast.makeText(this, "Must be a valid email", Toast.LENGTH_SHORT).show();
        return;
        }

        if(pswd.length() < 6){
            Toast.makeText(this, "Password is not long enough", Toast.LENGTH_SHORT).show();

        }


        pd.setMessage("Registering User....");
        pd.show();

        fbAuth.createUserWithEmailAndPassword(email, pswd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUpPage.this, "User registered.", Toast.LENGTH_SHORT).show();
                        pd.cancel();
                        } else {
                            Toast.makeText(SignUpPage.this, "Not Registered", Toast.LENGTH_SHORT).show();
                            pd.cancel();
                        }
                    }
                });
    }

    public void SignIn(View view) {
        startActivity(new Intent(SignUpPage.this, bottomNavActivity.class));
    }

    public void createAccountButton(View view) {
        startActivity(new Intent(SignUpPage.this, ActivityCreateAccount.class));
    }
}
