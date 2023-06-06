package com.example.ricegrow.Activity.Authenticate.LoginNormal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutName, textInputLayoutEmailRegister, textInputLayoutPasswordRegister, textInputLayoutRePassword,
                            textInputLayoutAddress, textInputLayoutPhoneNumber;
    private TextInputEditText edtName, edtEmail, edtPassword, edtRePassword, edtAddress, edtPhoneNumber;
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

        edtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutName, edtName);
                }
            }
        });

        edtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutEmailRegister, edtEmail);
                }
            }
        });

        edtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutPasswordRegister, edtPassword);
                }
            }
        });

        edtRePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutRePassword, edtRePassword);
                }
            }
        });

        edtAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutAddress, edtAddress);
                }
            }
        });

        edtPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateInput(textInputLayoutPhoneNumber, edtPhoneNumber);
                }
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputLayoutPasswordRegister.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtRePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputLayoutRePassword.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
                    textInputLayoutName.setError("Name is require");
                    return;
                }

                if (email.isEmpty()){
                    edtEmail.setError("Email is require");
                    textInputLayoutEmailRegister.setError("Email is require");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("Invalid email format");
                    textInputLayoutEmailRegister.setError("Invalid email format");
                    return;
                }

                if (pass.isEmpty()){
                    edtPassword.setError("Password is require");
                    textInputLayoutPasswordRegister.setEndIconVisible(false);
                    textInputLayoutPasswordRegister.setError("Password is require");
                    return;
                }
                if (pass.length()<6){
                    edtPassword.setError("Password must be >= 6");
                    textInputLayoutPasswordRegister.setEndIconVisible(false);
                    textInputLayoutPasswordRegister.setError("Password must be >= 6");
                    return;
                }

                if (rePass.isEmpty()){
                    edtRePassword.setError("Re-Password is require");
                    textInputLayoutRePassword.setEndIconVisible(false);
                    textInputLayoutRePassword.setError("Re-Password is require");
                    return;
                } else if (!rePass.equals(pass)) {
                    edtRePassword.setError("Re-Password is not same with password");
                    textInputLayoutRePassword.setEndIconVisible(false);
                    textInputLayoutRePassword.setError("Re-Password is not same with password");
                    return;
                }

                if (address.isEmpty()){
                    edtAddress.setError("Address is require");
                    textInputLayoutAddress.setError("Address is require");
                    return;
                }

                if (phone.isEmpty()){
                    edtPhoneNumber.setError("Phone number is require");
                    textInputLayoutPhoneNumber.setError("Phone number is require");
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
                            db.userDao().insert(new Users( FirebaseAuth.getInstance().getCurrentUser().getUid(),name, pass, email, address, "user", phone, "@drawable/default_avatar"));
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
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
        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutEmailRegister = findViewById(R.id.textInputLayoutEmailRegister);
        textInputLayoutPasswordRegister = findViewById(R.id.textInputLayoutPasswordRegister);
        textInputLayoutRePassword = findViewById(R.id.textInputLayoutRePassword);
        textInputLayoutAddress = findViewById(R.id.textInputLayoutAddress);
        textInputLayoutPhoneNumber = findViewById(R.id.textInputLayoutPhoneNumber);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmailRegister);
        edtPassword = findViewById(R.id.edtPasswordRegister);
        edtRePassword = findViewById(R.id.edtRePassword);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);
        progressBar = findViewById(R.id.progressBar);
        fb = FirebaseAuth.getInstance();
    }

    private void validateInput(TextInputLayout textInputLayout, TextInputEditText editText) {
        String input = editText.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            textInputLayout.setError("Input cannot be empty");
        } else {
            textInputLayout.setError(null);
        }
    }
}