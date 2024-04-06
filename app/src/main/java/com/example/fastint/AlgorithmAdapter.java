package com.example.fastint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlgorithmAdapter extends ArrayAdapter<AlgSort> {
    public AlgorithmAdapter(Context context, ArrayList<AlgSort> sections) {
        super(context, 0, sections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlgSort section = getItem(position);

        // Если view еще не создан, инфлируем его
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.algsort_item, parent, false);
        }

        // Находим элементы view и устанавливаем данные
        TextView textView = convertView.findViewById(R.id.button);

        // Устанавливаем текст и изображение из объекта Section
        textView.setText(section.getTitle());

        // Устанавливаем обработчик нажатия на кнопку
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код для открытия нового фрагмента
                if (textView.equals("Алгоритмы сортировок")) {

                } else if (textView.equals("Алгоритмы на строках")) {

                } else if (textView.equals("Алгоритмы на графах")) {

                } else if (textView.equals("Алгоритмы на отрезках")) {

                } else if (textView.equals("Алгоритмы на деревьях")) {

                }
            }
        });

        return convertView;
    }
}

