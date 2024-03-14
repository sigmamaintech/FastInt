package com.example.fastint;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUp2Binding;

import java.util.Objects;


public class Sign_up2 extends AppCompatActivity {
    private ActivitySignUp2Binding binding;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.CMPRegBut.setOnClickListener(v -> {
            if (Objects.requireNonNull(binding.NameSET.getText()).toString().isEmpty() || Objects.requireNonNull(binding.SurnameSET.getText()).toString().isEmpty() || binding.selectClass.toString().isEmpty() || (!binding.RBTeacher.isChecked() && !binding.RBStudent.isChecked())) {
                Toast.makeText(Sign_up2.this,  "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                boolean isTeach;
                isTeach = !binding.RBStudent.isChecked();
                User user = new User();
                user.writeNewUser(Sign_up.Reglogin, Sign_up.Regemail, Sign_up.Regpassword, binding.NameSET.getText().toString(), binding.SurnameSET.getText().toString(), 1, isTeach);
                startActivity(new Intent(Sign_up2.this, MainActivity.class));
                Toast.makeText(Sign_up2.this, "Регистрация не удалась", Toast.LENGTH_LONG).show();

            }
        });



        Spinner selectClass = findViewById(R.id.selectClass);
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        selectClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectClass.setAdapter(selectClassAdapter);
    }
}