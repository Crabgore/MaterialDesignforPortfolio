package com.geekbrains.materialdesignportfolio.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.materialdesignportfolio.R;
import com.geekbrains.materialdesignportfolio.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FruitFragment extends Fragment {
    private List<String> list = new ArrayList<>();
    private List<Drawable> drawables = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment, container, false);

        initLists();

        initRecycler(layout);

        return layout;
    }

    private void initLists() {
        list.add(getResources().getString(R.string.apple));
        list.add(getResources().getString(R.string.grape));
        list.add(getResources().getString(R.string.orange));
        list.add(getResources().getString(R.string.banana));
        list.add(getResources().getString(R.string.pineapple));

        drawables.add(getResources().getDrawable(R.drawable.apple));
        drawables.add(getResources().getDrawable(R.drawable.grape));
        drawables.add(getResources().getDrawable(R.drawable.orange));
        drawables.add(getResources().getDrawable(R.drawable.banana));
        drawables.add(getResources().getDrawable(R.drawable.pineapple));
    }

    private void initRecycler(View layout) {
        RecyclerView recyclerView = layout.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter myAdapter = new MyAdapter(list, drawables);
        recyclerView.setAdapter(myAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
