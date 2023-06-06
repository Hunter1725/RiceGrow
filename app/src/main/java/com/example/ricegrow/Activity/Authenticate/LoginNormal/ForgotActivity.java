package com.example.ricegrow.Activity.Authenticate.LoginNormal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputEditText edtEmailForgot;
    private Button btnResetPassword;
    private TextView txtBackToLogin;
    private ProgressBar progressBarForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmailForgot);
        edtEmailForgot = findViewById(R.id.edtEmailForgot);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        txtBackToLogin = findViewById(R.id.txtBackToLogin);
        progressBarForgotPassword = findViewById(R.id.progressBarForgotPassword);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmailForgot.getText().toString().trim();
                if (email.isEmpty()) {
                    textInputLayoutEmail.setError("Email entry required");
                    return;
                }
                progressBarForgotPassword.setVisibility(View.VISIBLE);

                FirebaseAuth auth = FirebaseAuth.getInstance();

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    progressBarForgotPassword.setVisibility(View.GONE);
                                    Toast.makeText(ForgotActivity.this, "Email sent! Check your email to reset your password!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
                                } else {
                                    progressBarForgotPassword.setVisibility(View.GONE);
                                    Toast.makeText(ForgotActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        txtBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
            }
        });

    }
}