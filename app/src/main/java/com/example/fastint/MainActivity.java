package com.example.fastint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
    }
    public void startSU (View v) {
        Intent to_sign_up = new Intent(this, Sign_up2.class);
        startActivity(to_sign_up);
    }
}