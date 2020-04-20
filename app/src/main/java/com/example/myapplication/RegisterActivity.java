package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    //created firebase object
    private FirebaseAuth mAuth;

    EditText username;
    EditText password;
    EditText full_name;
    EditText contact;

    ImageView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        //resource part
        Button b1=findViewById(R.id.Register);
        login=findViewById(R.id.gotologin);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        full_name=findViewById(R.id.fullname);
        contact=findViewById(R.id.phone);

        //initialising the instance

        //button action defined
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(password.length()>8)
                    createnewac(username.getText().toString(),password.getText().toString());
                else
                    Toast.makeText(getApplicationContext(),"Password too short",Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Loginpage.class));
                finish();
            }
        });
    }

//function to make account validate the details
     private void createnewac(final String email, final String password)
     {


     mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful())
             {mAuth.signInWithEmailAndPassword(email,password);
             FirebaseUser user=mAuth.getInstance().getCurrentUser();
                 UserProfileChangeRequest profileChangeRequest=new UserProfileChangeRequest().Builder().se;

                 startActivity(new Intent(getApplicationContext(),Listview.class));
             finish();
             }
         }



     });

     }
}

