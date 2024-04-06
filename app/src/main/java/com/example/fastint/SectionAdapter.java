package com.example.fastint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class SectionAdapter extends ArrayAdapter<Section> {
    private final FragmentManager fragmentManager;

    // Конструктор адаптера теперь принимает контекст и список объектов Section
    public SectionAdapter(Context context, ArrayList<Section> sections, FragmentManager fragmentManager) {
        super(context, 0, sections);
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Получаем объект Section для текущей позиции
        Section section = getItem(position);

        // Если view еще не создан, инфлируем его
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.section_item, parent, false);
        }

        // Находим элементы view и устанавливаем данные
        TextView textView = convertView.findViewById(R.id.button);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        // Устанавливаем текст и изображение из объекта Section
        textView.setText(section.getTitle());
        imageView.setImageResource(section.getImageResourceId());

        // Устанавливаем обработчик нажатия на кнопку
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь код для открытия нового фрагмента
                AlgSortFragment AlgSortOpenerFragment = new AlgSortFragment();
                /*Fragment newFragment = new AlgSortFragment();
                Fragment newFragment = new AlgSortFragment();
                Fragment newFragment = new AlgSortFragment();
                Fragment newFragment = new AlgSortFragment();*/
                if (textView.getText().equals("Алгоритмы сортировок")) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, AlgSortOpenerFragment)
                            .addToBackStack(null)
                            .commit();
                } else if (textView.getText().equals("Алгоритмы на строках")) {

                } else if (textView.getText().equals("Алгоритмы на графах")) {

                } else if (textView.getText().equals("Алгоритмы на отрезках")) {

                } else if (textView.getText().equals("Алгоритмы на деревьях")) {

                }
            }
        });

        return convertView;
    }
}

