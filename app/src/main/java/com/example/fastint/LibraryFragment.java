package com.example.fastint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        ListView listView = view.findViewById(R.id.list_view);

        // Создаем список объектов Section
        ArrayList<Section> sections = new ArrayList<>();
        // Заполняем список данными
        sections.add(new Section("Алгоритмы сортировок", R.drawable.sorting_algorithms));
        sections.add(new Section("Алгоритмы на строках", R.drawable.string_algorithms));
        sections.add(new Section("Алгоритмы на графах", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на отрезках", R.drawable.baseline_analytics_24));
        sections.add(new Section("Алгоритмы на деревьях", R.drawable.baseline_analytics_24));


        // Создаем адаптер и устанавливаем его для ListView
        SectionAdapter adapter = new SectionAdapter(getActivity(), sections, getFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}

