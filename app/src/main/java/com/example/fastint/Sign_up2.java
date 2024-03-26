package com.example.fastint;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUp2Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Sign_up2 extends AppCompatActivity {
    private ActivitySignUp2Binding binding;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    Button CMPReg_But;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        CMPReg_But = findViewById(R.id.CMPReg_But);

        final EditText email = findViewById(R.id.newEmail);
        final EditText login = findViewById(R.id.newLogin);
        final EditText password = findViewById(R.id.newPassword);
        final EditText name = findViewById(R.id.newName);
        final EditText surname = findViewById(R.id.newSurname);
        final Spinner selClass = findViewById(R.id.selectClass);
        CMPReg_But.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(surname.getText().toString()) || (!binding.RBTeacher.isChecked() && !binding.RBStudent.isChecked())) {
                Toast.makeText(Sign_up2.this,  "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                boolean isTeach;
                isTeach = !binding.RBStudent.isChecked();

                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(authResult -> {
                            User user = new User();
                            user.setLogin(login.getText().toString());
                            user.setEmail(email.getText().toString());
                            user.setPassword(password.getText().toString());
                            user.setName(name.getText().toString());
                            user.setSurname(surname.getText().toString());
                            user.setTeacher(isTeach);
                            user.setSelClass(Integer.parseInt(selClass.getSelectedItem().toString()));
                            users.child(user.getEmail())
                                    .setValue(user)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(Sign_up2.this, "Пользователь добавлен!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Sign_up2.this, MainActivity.class));
                                    });
                        });
            }
        });
    }
}