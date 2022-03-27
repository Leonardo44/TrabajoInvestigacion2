package com.llopez.geometricarea.circle_area;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.llopez.geometricarea.model.Circle;
import com.llopez.geometricarea.model.Triangle;

public class CircleAreaViewModel extends ViewModel {
    private MutableLiveData<Double> area;

    public MutableLiveData<Double> getCurrentArea() {
        if (area == null) {
            area = new MutableLiveData<>(Double.valueOf(0));
        }
        return area;
    }

    public void calculateArea(Double radius) {
        Circle circle = new Circle(radius);
        Double area = circle.area();

        getCurrentArea().setValue(area);
    }
}
