package com.example.fastint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void startSU2 (View v) {
        Intent to_sign_up2 = new Intent(this, Sign_up2.class);
        startActivity(to_sign_up2);
    }
}