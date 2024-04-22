package com.example.fastint;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    private final Context context;

    public AlgorithmAdapter(Context context, ArrayList<AlgSort> sections) {
        super(context, 0, sections);
        this.context = context;
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
                FileName = "bubble";
            } else if (textView.getText().equals("Вставками")) {
                FileName = "insert";
            } else if (textView.getText().equals("Быстрая сортировка (qsort)")) {
                FileName = "qsort";
            } else if (textView.getText().equals("Выбором")) {
                FileName = "selection";
            }
            context.startActivity(new Intent(context, PdfViewerActivity.class));
        });

        return convertView;
    }
}