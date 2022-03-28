package com.llopez.geometricarea.rectangle_area;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.llopez.geometricarea.model.Rectangle;

public class RectangleViewModel extends ViewModel {

    private MutableLiveData<Double> area;

    public MutableLiveData<Double> getCurrentArea() {
        if (this.area == null) {
            this.area = new MutableLiveData<>(Double.valueOf(0));
        }
        return this.area;
    }

    public void calculateArea(Double length, Double weidth) {
        Rectangle rectangle = new Rectangle(length, weidth);
        Double area = rectangle.area();
        getCurrentArea().setValue(area);
    }
}
