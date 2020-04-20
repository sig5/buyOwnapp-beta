package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        TextView displayname=findViewById(R.id.displayname);
        TextView email=findViewById(R.id.mail);
        EditText fullname=findViewById(R.id.profile_name);
        EditText contact=findViewById(R.id.pr_contact);
        EditText  password=findViewById(R.id.pr_contact);
        EditText conf_pass =findViewById(R.id.conpass);
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        String details=user.getDisplayName();
        String[] s;
        s=details.split("\\*",0);
        System.out.println(details);
        displayname.setText(s[0]);
        contact.setText(s[1]);
        fullname.setText(s[0]);

    }
}
