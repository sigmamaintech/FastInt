package com.example.fastint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fastint.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    private ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.SignInLogin.getText().toString().isEmpty() || binding.SignInPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Login or password fields cannot be blank", Toast.LENGTH_SHORT).show();
                }else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.SignInLogin.getText().toString(), binding.SignInPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        startActivity(new Intent(Sign_in.this, MainActivity.class));
                                    }
                                }
                            });

                }
            }
        });

        binding.RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_in.this, Sign_up.class));
            }
        });
    }
}