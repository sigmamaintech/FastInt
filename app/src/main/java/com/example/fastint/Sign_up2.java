package com.example.fastint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Sign_up2 extends AppCompatActivity {
    String[] classes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Spinner selectClass = findViewById(R.id.selectClass);
        ArrayAdapter<String> selectClassAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        selectClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectClass.setAdapter(selectClassAdapter);
    }
}