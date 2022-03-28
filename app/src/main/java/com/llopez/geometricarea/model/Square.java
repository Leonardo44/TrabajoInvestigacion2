package com.llopez.geometricarea.model;

public class Square extends Figure {

    private Double side;

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(this.side, 2);
    }
}
