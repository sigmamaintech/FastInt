package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignInBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    private ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBTN.setOnClickListener(v -> {
            if (binding.SignInLogin.getText().toString().isEmpty() || binding.SignInPassword.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Login or password fields cannot be blank", Toast.LENGTH_SHORT).show();
            }else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.SignInLogin.getText().toString(), binding.SignInPassword.getText().toString())
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                startActivity(new Intent(Sign_in.this, MainActivity.class));
                            }
                        });

            }
        });

        binding.RegButton.setOnClickListener(v -> startActivity(new Intent(Sign_in.this, Sign_up.class)));
    }
}