package com.geekbrains.materialdesignportfolio.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.geekbrains.materialdesignportfolio.R;
import com.geekbrains.materialdesignportfolio.adapters.MyTabsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NatureFragment extends Fragment {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    private List<String> descriptions = new ArrayList<>();
    private List<Drawable> drawables = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.nature_fragment, container, false);

        initLists();

        initFragments();

        initPager(layout);

        return layout;
    }

    private void initLists() {
        drawables.add(getResources().getDrawable(R.drawable.yosemite));
        drawables.add(getResources().getDrawable(R.drawable.zhangye));
        drawables.add(getResources().getDrawable(R.drawable.sagano));
        drawables.add(getResources().getDrawable(R.drawable.meteora));
        drawables.add(getResources().getDrawable(R.drawable.salar));

        descriptions.add(getResources().getString(R.string.yosemite));
        descriptions.add(getResources().getString(R.string.zhangye));
        descriptions.add(getResources().getString(R.string.sagano));
        descriptions.add(getResources().getString(R.string.meteora));
        descriptions.add(getResources().getString(R.string.salar));

        titles.add("Y");
        titles.add("Z");
        titles.add("B");
        titles.add("M");
        titles.add("S");
    }

    private void initFragments() {
        for (int i = 0; i < drawables.size(); i++) {
            fragments.add(new ItemFragment(drawables.get(i), descriptions.get(i)));
        }
    }

    private void initPager(View layout) {
        MyTabsAdapter myTabAdapter = new MyTabsAdapter(getChildFragmentManager(), fragments, titles);

        ViewPager viewPager = layout.findViewById(R.id.viewPager);
        viewPager.setAdapter(myTabAdapter);

        TabLayout tabLayout = layout.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
