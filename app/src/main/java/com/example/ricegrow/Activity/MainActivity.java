package com.example.ricegrow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.Authenticate.LoginNormal.LoginActivity;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView txtWelcome;
    private Button btnLogout;
    private FirebaseAuth fb;
    private RiceGrowDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = RiceGrowDatabase.getInstance(this);
        fb = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
        txtWelcome = findViewById(R.id.welcome);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address`
            String email = user.getEmail();
            String uid = user.getUid();
            boolean emailVerified = user.isEmailVerified();

            txtWelcome.setText("Welcome" + "\n" + email + "\n" + uid + "\n" + emailVerified);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb.signOut();
                Toast.makeText(MainActivity.this, "Sign out successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


        
    }
}