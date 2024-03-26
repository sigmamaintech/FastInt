package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUp2Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in extends AppCompatActivity {
    private ActivitySignUp2Binding binding;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    Button loginBtn;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        loginBtn = findViewById(R.id.loginBtn);

        final EditText email = findViewById(R.id.newEmail);
        final EditText password = findViewById(R.id.newPassword);
        loginBtn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(Sign_in.this,  "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(authResult -> {
                            startActivity(new Intent(Sign_in.this, MainActivity.class));
                            finish();
                        });
            }
        });
    }
}