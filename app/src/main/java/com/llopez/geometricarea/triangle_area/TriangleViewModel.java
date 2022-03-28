package com.llopez.geometricarea.triangle_area;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.llopez.geometricarea.model.Triangle;

public class TriangleViewModel extends ViewModel {
    private MutableLiveData<Double> area;

    public androidx.lifecycle.MutableLiveData<Double> getCurrentArea() {
        if (area == null) {
            area = new MutableLiveData<>(Double.valueOf(0));
        }
        return area;
    }

    public void calculateArea(Double base, Double height) {
        Triangle triangle = new Triangle(base, height);
        Double area = triangle.area();

        getCurrentArea().setValue(area);
    }
}
