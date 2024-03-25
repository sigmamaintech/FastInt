package com.example.fastint;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUp2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Sign_up2 extends AppCompatActivity {
    private ActivitySignUp2Binding binding;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        binding.CMPRegBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.NameSET.getText().toString().isEmpty() || binding.SurnameSET.getText().toString().isEmpty() || binding.selectClass.toString().isEmpty() || (!binding.RBTeacher.isChecked() && !binding.RBStudent.isChecked())) {
                    Toast.makeText(Sign_up2.this,  "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isTeach;
                    if (binding.RBStudent.isChecked()) {
                        isTeach = false;
                    } else {
                        isTeach = true;
                    }
                    auth.createUserWithEmailAndPassword(Sign_up.Regemail, Sign_up.Regpassword)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    User user = new User();
                                    user.setUsername(Sign_up.Reglogin);
                                    user.setName(binding.NameSET.toString());
                                    user.setSurname(binding.SurnameSET.toString());
                                    user.setPassword(Sign_up.Regpassword);
                                    user.setTeacher((Boolean) isTeach);
                                    user.setSelclass(1);
                                    users.child(user.getEmail())
                                            .setValue(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Toast.makeText(Sign_up2.this, "Пользователь добавлен!", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(Sign_up2.this, MainActivity.class));
                                                }
                                            });

                                }
                            });
                }
            }
        });



        Spinner selectClass = findViewById(R.id.selectClass);
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        selectClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectClass.setAdapter(selectClassAdapter);
    }
}