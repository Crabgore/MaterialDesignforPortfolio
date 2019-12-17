package com.geekbrains.materialdesignportfolio.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekbrains.materialdesignportfolio.R;

public class ItemFragment extends Fragment {
    private Drawable drawable;
    private String string;

    public ItemFragment() {}

    ItemFragment(Drawable drawable, String string) {
        this.drawable = drawable;
        this.string = string;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_item, container, false);

        initUI(layout);

        return layout;
    }

    private void initUI(View layout) {
        ImageView imageView = layout.findViewById(R.id.nature_image);
        TextView textView = layout.findViewById(R.id.nature_text);

        imageView.setImageDrawable(drawable);
        textView.setText(string);
    }

}
