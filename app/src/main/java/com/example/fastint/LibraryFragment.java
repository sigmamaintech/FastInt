package com.example.fastint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {
    private ListView listView;
    private SectionAdapter adapter;
    private ArrayList<Section> sections;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        listView = view.findViewById(R.id.list_view);

        // Создаем список объектов Section
        sections = new ArrayList<>();
        // Заполняем список данными
        sections.add(new Section("Алгоритмы сортировок", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на строках", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на графах", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на отрезках", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на деревьях", R.drawable.baseline_analytics_24));


        // Создаем адаптер и устанавливаем его для ListView
        adapter = new SectionAdapter(getActivity(), sections, getFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}

