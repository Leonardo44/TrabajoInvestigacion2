package com.llopez.geometricarea.square_area;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.llopez.geometricarea.model.Square;

public class SquareViewModel extends ViewModel {

    private MutableLiveData<Double> area;

    public MutableLiveData<Double> getCurrentData() {
        if (this.area == null) {
            this.area = new MutableLiveData<>(Double.valueOf(0));
        }
        return this.area;
    }

    public void calculateArea(Double side) {
        Square square = new Square(side);
        Double area = square.area();
        getCurrentData().setValue(area);
    }
}
