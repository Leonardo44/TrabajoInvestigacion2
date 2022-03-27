package com.llopez.geometricarea.rectangle_area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llopez.geometricarea.R;

public class RectangleAreaFragment extends Fragment {
    public RectangleAreaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_rectangle_area, container, false);
        return layout;
    }
}