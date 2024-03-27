package com.example.fastint;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Sign_up2 extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    Button regBtn;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        regBtn = findViewById(R.id.CMPReg_But);
        EditText name = findViewById(R.id.newName);
        EditText surname = findViewById(R.id.newSurname);
        Spinner selClass = findViewById(R.id.selectClass);
        RadioButton teacher = findViewById(R.id.RBTeacher);
        RadioButton student = findViewById(R.id.RBStudent);
        regBtn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(surname.getText().toString()) || (!teacher.isChecked() && !student.isChecked())) {
                Toast.makeText(Sign_up2.this,  "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                boolean isTeach = teacher.isChecked();
                auth.createUserWithEmailAndPassword(Sign_up.email, Sign_up.password)
                        .addOnSuccessListener(authResult -> {
                            User user = new User();
                            user.setLogin(Sign_up.login);
                            user.setEmail(Sign_up.email);
                            user.setPassword(Sign_up.password);
                            user.setName(name.getText().toString());
                            user.setSurname(surname.getText().toString());
                            user.setTeacher(isTeach);
                            user.setSelClass(Integer.parseInt(selClass.getSelectedItem().toString()));
                            users.child(user.getEmail()).setValue(user);
                        });
            }
        });
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        selectClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selClass.setAdapter(selectClassAdapter);
    }
}