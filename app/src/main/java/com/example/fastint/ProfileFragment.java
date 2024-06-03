package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fastint.Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference users;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        Button SOut = view.findViewById(R.id.sout);
        TextView Name = view.findViewById(R.id.name);
        TextView Surname = view.findViewById(R.id.surname);

        if (currentUser != null) {

            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            users.child("Users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        Name.setText(user.getName());
                        Surname.setText(user.getSurname());
                    } else {

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

        SOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            if (getContext() != null) { // Проверка контекста на null
                Intent intent = new Intent(getContext(), Sign_in.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        return view;
    }
}
