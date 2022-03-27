package com.llopez.geometricarea.model;

public class Circle extends  Figure {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
