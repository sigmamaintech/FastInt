package com.example.fastint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AlgSortFragment extends Fragment {
    private ListView listView;
    private AlgorithmAdapter adapter;
    private ArrayList<AlgSort> alg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_algsort, container, false);
        listView = view.findViewById(R.id.list_view);

        alg = new ArrayList<>();
        // Заполняем список данными
        alg.add(new AlgSort("Пузырьковая"));
        alg.add(new AlgSort("Подсчетом"));
        alg.add(new AlgSort("Быстрая сортировка (qsort)"));


        // Создаем адаптер и устанавливаем его для ListView
        adapter = new AlgorithmAdapter(getActivity(), alg);
        listView.setAdapter(adapter);

        return view;
    }
}

