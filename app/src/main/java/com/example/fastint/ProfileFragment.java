package com.example.fastint;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button SOut = view.findViewById(R.id.sout);
        SOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
//
//                // Переход обратно на экран входа
            Intent intent = new Intent(getContext(), Sign_in.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Очистка стека задач
            startActivity(intent);
        });
        return view;
    }
}