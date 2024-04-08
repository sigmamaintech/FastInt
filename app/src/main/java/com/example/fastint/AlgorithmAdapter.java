package com.example.fastint;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AlgorithmAdapter extends ArrayAdapter<AlgSort> {
    public static String FileName;
    public static TextView textView;

    public AlgorithmAdapter(Context context, ArrayList<AlgSort> sections) {
        super(context, 0, sections);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        AlgSort section = getItem(position);

        // Если view еще не создан, инфлируем его
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.algsort_item, parent, false);
        }

        // Находим элементы view и устанавливаем данные
        textView = convertView.findViewById(R.id.button);

        // Устанавливаем текст и изображение из объекта Section
        assert section != null;
        textView.setText(section.getTitle());

        // Устанавливаем обработчик нажатия на кнопку
        textView.setOnClickListener(v -> {
            // Здесь код для открытия нового фрагмента
            if (textView.getText().equals("Пузырьковая")) {
                FileName = "Пузырьковая сортировка";
                //Intent intent = new Intent(getApplicationContext(), PdfViewerActivity.class);
                //startActivity(intent);
            } else if (textView.getText().equals("Подсчетом")) {

            } else if (textView.getText().equals("Быстрая сортировка (qsort)")) {

            } else if (textView.getText().equals("Алгоритмы на строках")) {

            } else if (textView.getText().equals("Алгоритмы на строках")) {

            }
        });

        return convertView;
    }
}

