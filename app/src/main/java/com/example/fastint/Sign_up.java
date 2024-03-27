package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_up extends AppCompatActivity {
    Button next;
    public EditText RegEmail;
    public EditText RegPassword;
    public EditText RegLogin;
    public EditText RegPassword2;
    public static String email, login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        RegEmail = findViewById(R.id.newEmail);
        RegPassword = findViewById(R.id.newPassword);
        RegLogin = findViewById(R.id.newLogin);
        RegPassword2 = findViewById(R.id.CNewPassword);
        next = findViewById(R.id.NextPR_Btn);
        next.setOnClickListener(v -> {
            if (RegLogin.getText().toString().isEmpty() || RegEmail.getText().toString().isEmpty() || RegPassword.getText().toString().isEmpty()) {
                Toast.makeText(Sign_up.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else if (!RegPassword.getText().toString().equals(RegPassword2.getText().toString())) {
                Toast.makeText(Sign_up.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            } else {
                email = RegEmail.getText().toString();
                login = RegLogin.getText().toString();
                password = RegPassword.getText().toString();
                startActivity(new Intent(Sign_up.this, Sign_up2.class));
                finish();
            }
        });
    }
}