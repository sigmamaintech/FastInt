package com.example.fastint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AlgSortFragment extends Fragment {
    ArrayList<AlgSort> alg = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_algsort, container, false);
        ListView listView = view.findViewById(R.id.list_view);

        // Заполняем список данными
        alg.add(new AlgSort("Пузырьковая"));
        alg.add(new AlgSort("Вставками"));
        alg.add(new AlgSort("Выбором"));
        alg.add(new AlgSort("Быстрая сортировка (qsort)"));

        // Создаем адаптер и устанавливаем его для ListView
        AlgorithmAdapter adapter = new AlgorithmAdapter(getActivity(), alg);
        listView.setAdapter(adapter);
        return view;
    }
}

