package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    Button loginBtn, regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        loginBtn = findViewById(R.id.loginBtn);
        regBtn = findViewById(R.id.regButton);
        final EditText email = findViewById(R.id.signinEmail);
        final EditText password = findViewById(R.id.signinPassword);

        loginBtn.setOnClickListener(v -> {
            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Поля логина и пароля не должны быть пустыми", Toast.LENGTH_SHORT).show();
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                startActivity(new Intent(Sign_in.this, MainActivity.class));
                            }
                        });

            }
        });

        regBtn.setOnClickListener(v -> startActivity(new Intent(Sign_in.this, Sign_up.class)));
    }
}