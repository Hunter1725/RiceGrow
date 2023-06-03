package com.example.ricegrow.Activity.Authenticate.LoginNormal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.Users;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPassword, edtRePassword, edtAddress, edtPhoneNumber;
    private Button btnRegister;
    private TextView txtLogin;
    private ProgressBar progressBar;
    private FirebaseAuth fb;
    private RiceGrowDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = RiceGrowDatabase.getInstance(this);
        initView();

        if(fb.getCurrentUser() != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString().trim();
                String pass = edtPassword.getText().toString();
                String rePass = edtRePassword.getText().toString();
                String address = edtAddress.getText().toString();
                String phone = edtPhoneNumber.getText().toString().trim();

                if (name.isEmpty()){
                    edtName.setError("Name is require");
                    return;
                }

                if (email.isEmpty()){
                    edtEmail.setError("Email is require");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("Invalid email format");
                    return;
                }

                if (pass.isEmpty()){
                    edtPassword.setError("Password is require");
                    return;
                }
                if (pass.length()<6){
                    edtPassword.setError("Password must be >= 6");
                    return;
                }

                if (rePass.isEmpty()){
                    edtRePassword.setError("Re-Password is require");
                    return;
                } else if (!rePass.equals(pass)) {
                    edtRePassword.setError("Re-Password is not same with password");
                    return;
                }

                if (address.isEmpty()){
                    edtAddress.setError("Address is require");
                    return;
                }

                if (phone.isEmpty()){
                    edtPhoneNumber.setError("Phone number is require");
                    return;
                }

                //Create user on firebase
                progressBar.setVisibility(View.VISIBLE);
                fb.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            db.userDao().insert(new Users( FirebaseAuth.getInstance().getCurrentUser().getUid(),name, pass, email, address, "user", phone));
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void initView() {
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);
        progressBar = findViewById(R.id.progressBar);
        fb = FirebaseAuth.getInstance();
    }
}