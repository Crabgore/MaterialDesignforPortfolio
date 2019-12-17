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

public class VegetableFragment extends Fragment {
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
        list.add(getResources().getString(R.string.carrot));
        list.add(getResources().getString(R.string.tomato));
        list.add(getResources().getString(R.string.pickle));
        list.add(getResources().getString(R.string.onion));
        list.add(getResources().getString(R.string.cabbage));

        drawables.add(getResources().getDrawable(R.drawable.carrot));
        drawables.add(getResources().getDrawable(R.drawable.tomato));
        drawables.add(getResources().getDrawable(R.drawable.pickle));
        drawables.add(getResources().getDrawable(R.drawable.onion));
        drawables.add(getResources().getDrawable(R.drawable.cabbage));
    }

    private void initRecycler(View layout) {
        RecyclerView recyclerView = layout.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter myAdapter = new MyAdapter(list, drawables);
        recyclerView.setAdapter(myAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
