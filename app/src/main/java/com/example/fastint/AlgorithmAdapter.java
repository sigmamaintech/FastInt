package com.example.fastint;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AlgorithmAdapter extends ArrayAdapter<Alg> {
    public static String FileName;
    private final Context context;

    public AlgorithmAdapter(Context context, ArrayList<Alg> sections) {
        super(context, 0, sections);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Alg section = getItem(position);

        // Если view еще не создан, инфлируем его
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.algsort_item, parent, false);
        }

        // Находим элементы view и устанавливаем данные
        TextView textView = convertView.findViewById(R.id.button);

        // Устанавливаем текст и изображение из объекта Section
        assert section != null;
        textView.setText(section.getTitle());

        // Устанавливаем обработчик нажатия на кнопку
        textView.setOnClickListener(v -> {
            // Здесь код для открытия нового фрагмента
            switch (section.getTitle()) {
                case "Пузырьковая":
                    FileName = "bubble";
                    break;
                case "Вставками":
                    FileName = "insert";
                    break;
                case "Быстрая сортировка (qsort)":
                    FileName = "qsort";
                    break;
                case "Выбором":
                    FileName = "selection";
                    break;
                case "Представление графов в памяти":
                    FileName = "memory";
                    break;
                case "Поиск в глубину (DFS)":
                    FileName = "dfs";
                    break;
                case "Поиск в ширину (BFS)":
                    FileName = "bfs";
                    break;
                case "Топологическая сортировка":
                    FileName = "topSort";
                    break;
                case "Структура дерево отрезков. Базовые операции":
                    FileName = "segbase";
                    break;
                case "Отрезок с максимальной суммой, максимальная последовательность нулей, последовательность возрастающая на 1":
                    FileName = "segmaxsum";
                    break;
                case "Ближайший меньший на отрезке, К-я единица":
                    FileName = "segked";
                    break;
                case "Массовые операции. Прибавление на отрезке и значение в точке":
                    FileName = "segmasprib";
                    break;
                case "Массовые операции. Прибавление и минимум на отрезке":
                    FileName = "segmasmin";
                    break;
                case "Массовые операции. Проталкивание":
                    FileName = "segmaspush";
                    break;
            }
            context.startActivity(new Intent(context, PdfViewerActivity.class));
        });

        return convertView;
    }
}