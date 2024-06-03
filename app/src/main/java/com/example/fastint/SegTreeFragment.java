package com.example.fastint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SegTreeFragment extends Fragment {
    ArrayList<Alg> alg = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segtree, container, false);
        ListView listView = view.findViewById(R.id.list_view);

        // Заполняем список данными
        alg.add(new Alg("Структура дерево отрезков. Базовые операции"));
        alg.add(new Alg("Отрезок с максимальной суммой, максимальная последовательность нулей, последовательность возрастающая на 1"));
        alg.add(new Alg("Ближайший меньший на отрезке, К-я единица"));
        alg.add(new Alg("Массовые операции. Прибавление на отрезке и значение в точке"));
        alg.add(new Alg("Массовые операции. Прибавление и минимум на отрезке"));
        alg.add(new Alg("Массовые операции. Проталкивание"));

        // Создаем адаптер и устанавливаем его для ListView
        AlgorithmAdapter adapter = new AlgorithmAdapter(getActivity(), alg);
        listView.setAdapter(adapter);
        return view;
    }
}

