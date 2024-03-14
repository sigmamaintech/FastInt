package com.example.fastint;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Objects;

@IgnoreExtraProperties
public class User {

    public String username;
    public String email;
    public String password;
    public String name;
    public String surname;
    public Integer selclass;
    public Boolean isTeacher;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password, String name, String surname, Integer selclass, Boolean isTeacher) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.selclass = selclass;
        this.isTeacher = isTeacher;
    }

    public void writeNewUser(String username, String email, String password, String name, String surname, Integer selclass, Boolean isTeacher) {
        //DatabaseReference UserDatabase;
        //UserDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        User user = new User(username, email, password, name, surname, selclass, isTeacher);
                        FirebaseDatabase.getInstance().getReference().child("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                .setValue(user);
                    }
                });
    }
}
