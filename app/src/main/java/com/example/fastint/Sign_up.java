package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUpBinding;

public class Sign_up extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    public static String regEmail = String.valueOf(R.id.newEmail);
    public static String regPassword = String.valueOf(R.id.newPassword);
    public static String regLogin = String.valueOf(R.id.newLogin);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.NextPRBtn.setOnClickListener(v -> {
            if (regLogin.isEmpty() || regPassword.isEmpty()) {
                Toast.makeText(Sign_up.this, "Заполните поля логина и пароля", Toast.LENGTH_SHORT).show();
            } else if (!binding.newPassword.getText().toString().equals(binding.CNewPassword.getText().toString())) {
                Toast.makeText(Sign_up.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(Sign_up.this, Sign_up2.class));
            }
        });
    }
}