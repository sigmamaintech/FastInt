package com.example.fastint;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastint.databinding.ActivitySignUp2Binding;

public class Sign_up2 extends AppCompatActivity {
    private ActivitySignUp2Binding binding;
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*binding.CMPRegBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(Sign_up.Regemail, Regpassword)
                        .addOnCompleteListener(Sign_up2.this, (OnCompleteListener<AuthResult>) task -> {
                            if (task.isSuccessful()) {
                                // Регистрация успешна
                                FirebaseUser user = mAuth.getCurrentUser();

                                // Добавляем данные пользователя в базу данных Firebase
                                String userId = user.getUid();
                                String login = Sign_up.Reglogin;
                                String name = String.valueOf(R.id.NameS_ET);
                                String surname = String.valueOf(R.id.SurnameS_ET);
                                String fathername = String.valueOf(R.id.FNameS_ET);
                                String classValue = String.valueOf(R.id.selectClass);
                                String isTeacher = String.valueOf(binding.RBTeacher.isChecked());
                                //User newUser = new User(login);

                                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("users");
                                databaseRef.child(userId).setValue("jdfdj");
                            } else {
                                // Регистрация не удалась
                                Toast.makeText(Sign_up2.this, "Ошибка регистрации.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        */


        Spinner selectClass = findViewById(R.id.selectClass);
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        selectClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectClass.setAdapter(selectClassAdapter);
    }
}